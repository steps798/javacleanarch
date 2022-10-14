package com.steph.cleanarch.external.application.port.out.cloudstorage;

public record DownloadDto(
    byte[] data,
    String contentType,
    Long contentLength,
    String fileKey
) {

}
