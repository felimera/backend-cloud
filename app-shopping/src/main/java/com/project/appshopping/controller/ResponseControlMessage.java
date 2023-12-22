package com.project.appshopping.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseControlMessage {
    private String code;
    private String message;
    private List<ErrorMessage> errorMessages;
}
