package com.rafael.hexagonal.architecture.adapters.in.controller.handler;

import lombok.Data;

@Data
public class StandardError {
    
    private Long timestamp;
    private Integer status;
    private String message;
    private String path;

}
