package com.ilog.lib.common.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DBExceptionMapping {
    private String name;
    private String message;
}
