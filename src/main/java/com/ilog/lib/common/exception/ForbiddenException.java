package com.ilog.lib.common.exception;

import com.ilog.lib.common.exception.ApiException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiException {
    public ForbiddenException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
