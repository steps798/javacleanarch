package com.steph.cleanarch.external.adapter.out.cloudstorage;

import com.steph.cleanarch.external.application.port.out.cloudstorage.CloudStorageGateway;
import com.steph.cleanarch.external.application.port.out.cloudstorage.DownloadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class S3StorageGateway implements CloudStorageGateway {

    private final S3UploadService s3UploadService;

    private final S3DownloadService s3DownloadService;

    @Override
    public DownloadDto downloadFile(String fileKey) {
        return s3DownloadService.downloadFile(fileKey);
    }

    @Override
    public String uploadFile(FilePart file, String fileName) {
        return s3UploadService.uploadFile(file, fileName);
    }
}
