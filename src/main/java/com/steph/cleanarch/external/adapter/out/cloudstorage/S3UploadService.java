package com.steph.cleanarch.external.adapter.out.cloudstorage;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkResponse;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final S3AsyncClient s3AsyncClient;

    private final S3Client s3Client;

    private final S3ConfigProperties s3Props;

    /**
     * Holds upload state during a multipart upload
     */
    static class UploadState {
        final String bucket;
        final String filekey;

        String uploadId;
        int partCounter;
        Map<Integer, CompletedPart> completedParts = new HashMap<>();
        int buffered = 0;

        UploadState(String bucket, String filekey) {
            this.bucket = bucket;
            this.filekey = filekey;
        }
    }

    public String uploadFile(FilePart file, String fileName) {

        String fileKey = buildFileKey(fileName);

        CreateMultipartUploadResponse uploadRequest = s3Client
            .createMultipartUpload(buildUploadRequest(fileKey, fileName));

        final UploadState uploadState = new UploadState(s3Props.getBucket(), fileKey);

//        return Mono
//            .fromFuture(uploadRequest)
//            .flatMapMany(response -> {
//                checkResult(response);
//                uploadState.uploadId = response.uploadId();
//                return file.content();
//            })
//            .bufferUntil(buffer -> {
//                uploadState.buffered += buffer.readableByteCount();
//                if (uploadState.buffered >= s3Props.getMultipartMinPartSize()) {
//                    uploadState.buffered = 0;
//                    return true;
//                } else {
//                    return false;
//                }
//            })
//            .map(S3UploadService::concatBuffers)
//            .flatMap(buffer -> uploadPart(uploadState, buffer))
//            .onBackpressureBuffer()
//            .reduce(uploadState, (state, completedPart) -> {
//                state.completedParts.put(completedPart.partNumber(), completedPart);
//                return state;
//            })
//            .flatMap(this::completeUpload)
//            .map(response -> {
//                checkResult(response);
//                return uploadState.filekey;
//            });
        return fileKey;
    }

    /**
     * check result from an API call.
     *
     * @param result Result from an API call
     */
    private static void checkResult(SdkResponse result) {
        if (result.sdkHttpResponse() == null || !result.sdkHttpResponse().isSuccessful()) {
            throw new UploadFailedException(
                result.sdkHttpResponse().statusText()
                    .orElse("s3 upload exit with unknown status")
            );
        }
    }

    /**
     * Upload a single file part to the requested bucket
     *
     * @param uploadState hold current upload state
     * @param buffer      data byte
     * @return CompletedPart
     */
    private CompletedPart uploadPart(UploadState uploadState, ByteBuffer buffer) {
        final int partNumber = ++uploadState.partCounter;

        UploadPartResponse request = s3Client.uploadPart(UploadPartRequest.builder()
                .bucket(uploadState.bucket)
                .key(uploadState.filekey)
                .partNumber(partNumber)
                .uploadId(uploadState.uploadId)
                .contentLength((long) buffer.capacity())
                .build(),
            RequestBody.fromByteBuffer(buffer));

        checkResult(request);

        return CompletedPart.builder()
            .eTag(request.eTag())
            .partNumber(partNumber)
            .build();
    }

    private CreateMultipartUploadRequest buildUploadRequest(String fileKey, String fileName) {

        // Gather metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("filename", fileName);

        return CreateMultipartUploadRequest.builder()
            .contentType(MediaType.APPLICATION_OCTET_STREAM.toString())
            .key(fileKey)
            .metadata(metadata)
            .bucket(s3Props.getBucket())
            .build();
    }

    private static ByteBuffer concatBuffers(List<DataBuffer> buffers) {

        int partSize = 0;
        for (DataBuffer b : buffers) {
            partSize += b.readableByteCount();
        }

        ByteBuffer partData = ByteBuffer.allocate(partSize);
        buffers.forEach(buffer -> partData.put(buffer.asByteBuffer()));

        // Reset read pointer to first byte
        partData.rewind();

        return partData;

    }

    private CompleteMultipartUploadResponse completeUpload(UploadState state) {

        CompletedMultipartUpload multipartUpload = CompletedMultipartUpload.builder()
            .parts(state.completedParts.values())
            .build();

        return s3Client.completeMultipartUpload(CompleteMultipartUploadRequest.builder()
            .bucket(state.bucket)
            .uploadId(state.uploadId)
            .multipartUpload(multipartUpload)
            .key(state.filekey)
            .build());
    }

    private static String buildFileKey(String fileName) {
//        String fileExt = FilenameUtils.getExtension(fileName);
//        String fileBaseName = FilenameUtils.getBaseName(fileName);
//        return fileBaseName + "-" + UUID.randomUUID().toString() + "." + fileExt;
        return fileName;
    }
}
