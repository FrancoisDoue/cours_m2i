package com.example.springsecurityjwt.dto;

import lombok.Data;

@Data
public class BaseResponseDTO {
    private Object message;
    private Object data;

    public BaseResponseDTO(Object message) {
        this.message = message;
    }

    public BaseResponseDTO(Object message, Object data) {
        this.message = message;
        this.data = data;
    }


}
