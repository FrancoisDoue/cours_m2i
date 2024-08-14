package com.example.microservice_ex1_order.controller;

import com.example.microservice_ex1_order.dto.OrderGetDTO;
import com.example.microservice_ex1_order.dto.OrderPostDTO;
import com.example.microservice_ex1_order.entity.Order;
import com.example.microservice_ex1_order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderGetDTO> createOrder(@RequestBody OrderPostDTO order) {
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderGetDTO>> getOrder(@PathVariable int userId) {
        return ResponseEntity.ok(orderService.findAllByUserId(userId));
    }

}
