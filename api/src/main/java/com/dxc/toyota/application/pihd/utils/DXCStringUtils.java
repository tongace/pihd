package com.dxc.toyota.application.pihd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DXCStringUtils {
    private static final ObjectMapper OBJECT_MAPPER_SINGLETON = new ObjectMapper();
    private DXCStringUtils(){}
    public static String serializeObjectToJSON(final Object object){
        try {
            return OBJECT_MAPPER_SINGLETON.writeValueAsString(object);
        } catch (final JsonProcessingException e) {
            return String.valueOf(object);
        }
    }
    public static <T> T deserializeJSONToObject(String jsonString, Class<T> clazz) {
        T obj = null;
        try {
            obj = OBJECT_MAPPER_SINGLETON.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
