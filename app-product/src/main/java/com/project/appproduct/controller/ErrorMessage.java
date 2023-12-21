package com.project.appproduct.controller;

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
