package com.ilog.lib.common.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilog.lib.common.model.DBExceptionMapping;
import com.ilog.lib.common.model.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.File;
import java.util.Collections;
import java.util.List;


@RestControllerAdvice
@Slf4j
public class DatabaseExceptionHandler {

    private static final String MAPPING_FILE = "classpath:sql_exceptions_mapping.json";
    private static final String DEFAULT_MESSAGE = "Error Persisting data";
    private static  List<DBExceptionMapping> dbExceptionMappings;

    static {
        try {
            var objectMapper = new ObjectMapper();
            File file = ResourceUtils.getFile(MAPPING_FILE);
            dbExceptionMappings = objectMapper.readValue(file, new TypeReference<>(){});

        }catch (Exception ex){
            log.error("failed to fetch and/or construct database exceptions mappings: {}", ex.getMessage());
            dbExceptionMappings = Collections.emptyList();
        }

    }

    @ExceptionHandler ({DataAccessException.class})
    protected ResponseEntity<ErrorDto> handleDatabaseException(
            DataAccessException ex) {

        var mapping = dbExceptionMappings.stream()
                .filter(dbExceptionMapping -> ex.getMessage().contains(dbExceptionMapping.getName()))
                .findAny();

        var status = HttpStatus.BAD_REQUEST;
        var message = mapping.isPresent() ? mapping.get().getMessage(): DEFAULT_MESSAGE;
        var error = ErrorDto.builder()
                .message(message)
                .code(status.getReasonPhrase())
                .details(List.of(ex.getMessage()))
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
