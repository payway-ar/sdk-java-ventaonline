package com.decidir.sdk.converters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;

/**
 * Created by ivalek on 1/18/18.
 */
public class DecidirConverter {

    private final ObjectMapper objectMapper;

    public DecidirConverter() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper = new ObjectMapper().addHandler(new DeserializationProblemHandler() {
            @Override
            public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser jp, JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName) throws IOException, JsonProcessingException {
            	jp.skipChildren();
                return true;
            }
        });
        objectMapper.setDateFormat(dateFormat);
    }

    public final <T> T convert(byte[] bytes, Class<T> toClass) throws IOException {
        return objectMapper.readValue(bytes, toClass);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper.copy();
    }
}
