package com.omertasci.passvault.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapUtil {

    @Autowired
    ObjectMapper objectMapper;

    public <T> T map(Object source, Class<T> targetClass) {
        return objectMapper.convertValue(source, targetClass);
    }

    public <T> List<T> typeCastList(final Iterable<?> fromList,
                                    final Class<T> instanceClass) {
        final List<T> list = new ArrayList<>();
        for (final Object item : fromList) {
            final T entry = item instanceof List<?> ? instanceClass.cast(item) : objectMapper.convertValue(item, instanceClass);
            list.add(entry);
        }

        return list;
    }
}
