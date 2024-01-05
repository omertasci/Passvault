package com.omertasci.passvault.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomStringSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(s != null && !s.isEmpty() && !s.equals("null")) {
            jsonGenerator.writeString(s.toUpperCase());
        } else {
            jsonGenerator.writeNull();
        }
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }
}
