package com.liqiwen.media.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public final class JsonUtil {

    private static ObjectMapper objectMapper;


    static {
        objectMapper = new ObjectMapper();
    }


    public static Object json2Obj(String str, Class clazz) {
        try {
            return objectMapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Map<String, Object> json2Map(String str) {
        try {
            return (Map<String, Object>) objectMapper.readValue(str, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
