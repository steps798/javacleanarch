package com.steph.cleanarch.external.application.port.out.cloudstorage;

import org.springframework.http.codec.multipart.FilePart;

public interface CloudStorageGateway {

    /**
     * Download file from cloud storage based on fileKey
     *
     * @param fileKey - unique key of file stored in cloud
     * @return downloaded data data transfer
     */
    DownloadDto downloadFile(String fileKey);

    /**
     * Upload file to cloud storage
     *
     * @param file - file parts data
     * @param fileName - name of the file
     * @return unique fileKey of the uploaded file
     */
    String uploadFile(FilePart file, String fileName);
}
