package com.steph.cleanarch.external.adapter.out.cloudstorage;

public class DownloadFailedException extends RuntimeException {

    private static final long serialVersionUID = -9038439813305692808L;

    public DownloadFailedException() {
    }

    public DownloadFailedException(String message) {
        super(message);
    }

    public DownloadFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
