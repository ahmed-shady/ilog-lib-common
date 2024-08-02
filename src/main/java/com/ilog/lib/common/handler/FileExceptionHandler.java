package com.ilog.lib.common.handler;

import com.ilog.lib.common.model.ErrorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;



@RestControllerAdvice
public class FileExceptionHandler {
    @Value("${spring.servlet.multipart.max-file-size:10MB}")
    private String maxSize;

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorDto> handleUploadSizeExceeded(final MaxUploadSizeExceededException ex) {
        var httpStatus = HttpStatus.BAD_REQUEST;
        var message = "%s: %s".formatted(ex.getMessage(), String.valueOf(maxSize));
        ErrorDto error = ErrorDto.builder().message(message).code(httpStatus.getReasonPhrase()).build();
        return new ResponseEntity<>(error, httpStatus);
    }

}
