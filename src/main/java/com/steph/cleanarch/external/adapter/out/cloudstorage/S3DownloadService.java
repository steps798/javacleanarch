package com.steph.cleanarch.external.adapter.out.cloudstorage;

import com.steph.cleanarch.external.application.port.out.cloudstorage.DownloadDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3DownloadService {

    private final S3Client s3Client;

    private final S3ConfigProperties s3Props;

    @SneakyThrows
    public DownloadDto downloadFile(String fileKey) {
        GetObjectRequest request = GetObjectRequest.builder()
            .bucket(s3Props.getBucket())
            .key(fileKey)
            .build();

        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(request);

        checkResult(response.response());

        return new DownloadDto(
            response.readAllBytes(),
            S3ContentType.getType(fileKey).getContentType(),
            response.response().contentLength(),
            fileKey
        );
    }

    private static void checkResult(GetObjectResponse response) {
        SdkHttpResponse sdkResponse = response.sdkHttpResponse();
        if (sdkResponse != null && sdkResponse.isSuccessful()) {
            return;
        }

        throw new DownloadFailedException(
            response.sdkHttpResponse().statusText()
                .orElse("s3 download exit with unknown status")
        );
    }

}
