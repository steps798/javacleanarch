package com.steph.cleanarch.external.adapter.out.cloudstorage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum S3ContentType {
    UNKNOWN("application/octet-stream"),
    JPEG("image/jpeg"),
    PNG("image/png");

    private final String contentType;

    public static S3ContentType getType(String fileName) {
//        String ext = FilenameUtils.getExtension(fileName);

//        List<String> jpegExtensions = Arrays.asList("jpeg", "jpg");
//        if (jpegExtensions.contains(ext)) {
//            return JPEG;
//        }
//
//        List<String> pngExtensions = Collections.singletonList("png");
//        if (pngExtensions.contains(ext)) {
//            return PNG;
//        }

        return UNKNOWN;
    }
}
