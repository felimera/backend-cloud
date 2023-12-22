package com.project.appcustomer.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private String attributeName;
    private String attributeValue;
}
