package com.steph.cleanarch.external.adapter.out.cloudstorage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;

@Data
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "features.aws.s3")
public class S3ConfigProperties {

    private String bucket;

    private Region region = Region.AP_SOUTHEAST_1;

    // AWS S3 requires that file parts must have at least 5MB, except for the last part.
    private int multipartMinPartSize = 5*1024*1024;
}
