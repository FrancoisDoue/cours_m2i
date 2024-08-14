package com.example.microservice_ex1_order.service;

import com.example.microservice_ex1_order.config.RestClient;
import com.example.microservice_ex1_order.dto.OrderGetDTO;
import com.example.microservice_ex1_order.dto.OrderPostDTO;
import com.example.microservice_ex1_order.dto.UserDTO;
import com.example.microservice_ex1_order.entity.Order;
import com.example.microservice_ex1_order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestClient restClient;

    public OrderService(OrderRepository orderRepository, RestClient restClient) {
        this.orderRepository = orderRepository;
        this.restClient = restClient;
    }

    public OrderGetDTO save(OrderPostDTO orderDto) {
        UserDTO userDTO = (UserDTO) restClient.Get("users/"+orderDto.getUserId(), UserDTO.class);
        Order order = new Order(0, orderDto.getUserId(), orderDto.getProduct());
        order = orderRepository.save(order);
        return OrderGetDTO.builder()
                .id(order.getId())
                .user(userDTO)
                .product(order.getProduct())
                .build();
    }

    public List<OrderGetDTO> findAllByUserId(int userId) {
        UserDTO userDTO = (UserDTO) restClient.Get("users/"+userId, UserDTO.class);
        return orderRepository.findByUserId(userId).stream()
                .map(o -> OrderGetDTO.builder()
                        .id(o.getId())
                        .user(userDTO)
                        .product(o.getProduct())
                        .build())
                .toList();
    }
}
