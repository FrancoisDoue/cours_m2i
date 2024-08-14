package com.example.microservice_ex1_order.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderGetDTO {
    private int id;
    private UserDTO user;
    private String product;
}
