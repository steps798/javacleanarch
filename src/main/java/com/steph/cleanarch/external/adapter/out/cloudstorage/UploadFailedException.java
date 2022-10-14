package com.steph.cleanarch.external.adapter.out.cloudstorage;

public class UploadFailedException extends RuntimeException {

    private static final long serialVersionUID = -8609527708080785863L;

    public UploadFailedException() {
    }

    public UploadFailedException(String message) {
        super(message);
    }

    public UploadFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
