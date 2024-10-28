package com.ilog.lib.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonMapper {
    @Autowired
    private ObjectMapper objectMapper;

    public String convertObjectToJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(object);
        }catch(JsonProcessingException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
