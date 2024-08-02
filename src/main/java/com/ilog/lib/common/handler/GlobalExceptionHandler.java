package com.ilog.lib.common.handler;

import com.ilog.lib.common.exception.ApiException;
import com.ilog.lib.common.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDto> handleApiException(final ApiException ex) {
        ErrorDto error = ErrorDto.builder().message(ex.getMessage()).code(ex.getStatus().getReasonPhrase()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }


    @ExceptionHandler ({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<ErrorDto> handleOtherExceptions(
            Exception ex) {

        var status = HttpStatus.BAD_REQUEST;

        var error = ErrorDto.builder().message(ex.getMessage())
                .code(status.getReasonPhrase())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler ({MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorDto> handleConstraintViolationException(
            MethodArgumentNotValidException ex) {

        var status = HttpStatus.BAD_REQUEST;
        var details = ex.getBindingResult().getAllErrors().stream()
                .map(err -> err.getDefaultMessage())
                .filter(Objects::nonNull)
                .toList();
        var error = ErrorDto.builder().message(details.stream().findAny().orElse(null))
                .code(status.getReasonPhrase())
                .details(details).build();
        return new ResponseEntity<>(error, status);
    }

}
