package com.ilog.lib.common.util;


import org.springframework.util.StringUtils;

public class ILogStringUtils {
    private ILogStringUtils(){}

    public static String capitalizeFirstLetterOnly(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        input = input.toLowerCase();  // Convert entire string to lowercase
        return StringUtils.capitalize(input);  // Capitalize the first letter
    }
}
