package com.steph.cleanarch.external.adapter.out.cloudstorage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
//import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3AsyncClientBuilder;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class S3ClientConfiguration {

    private final S3ConfigProperties s3props;

    private final AwsCredentialsProvider credentialsProvider;

    @Bean
    public S3AsyncClient s3client() {
//        SdkAsyncHttpClient httpClient = NettyNioAsyncHttpClient.builder()
//            .writeTimeout(Duration.ZERO)
//            .maxConcurrency(64)
//            .build();
        S3Configuration serviceConfiguration = S3Configuration.builder()
            .checksumValidationEnabled(false)
            .chunkedEncodingEnabled(true)
            .build();
        S3AsyncClientBuilder asyncBuilder = S3AsyncClient.builder()
            .httpClient(null)
//            .httpClient(httpClient)
            .region(s3props.getRegion())
            .credentialsProvider(credentialsProvider)
            .serviceConfiguration(serviceConfiguration);

        return asyncBuilder.build();
    }
}
