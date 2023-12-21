package com.project.appproduct.utils;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.project.appproduct.controller.ErrorMessage;
import org.springframework.validation.BindingResult;

import java.util.List;

public class CadenaUtil {

    private CadenaUtil() {
        throw new IllegalStateException(CadenaUtil.class.toString());
    }

    public static String convertBodyToJson(String attributeName, Object body) {
        JsonObject json = new JsonObject();
        json.put(attributeName, body);
        return json.toString();
    }

    public static List<ErrorMessage> formatMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(err -> ErrorMessage.builder().attributeName(err.getField()).attributeValue(err.getDefaultMessage()).build())
                .toList();
    }
}
