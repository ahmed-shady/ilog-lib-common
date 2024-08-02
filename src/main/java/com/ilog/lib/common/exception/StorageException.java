package com.ilog.lib.common.exception;

import org.springframework.http.HttpStatus;

public class StorageException extends ApiException {

    public StorageException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}