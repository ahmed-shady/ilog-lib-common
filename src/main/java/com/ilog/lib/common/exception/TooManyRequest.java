package com.ilog.lib.common.exception;

import org.springframework.http.HttpStatus;

public class TooManyRequest extends ApiException {
    public TooManyRequest(String message) {
        super(message, HttpStatus.TOO_MANY_REQUESTS);
    }

}
