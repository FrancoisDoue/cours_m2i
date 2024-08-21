package com.example.service;

import com.example.client.ClientServiceClient;
import com.example.client.ProductServiceClient;
import com.example.dto.ClientDTO;
import com.example.dto.ProductDTO;
import com.example.entity.Order;
import com.example.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Inject @RestClient
    ClientServiceClient clientServiceClient;

    @Inject @RestClient
    ProductServiceClient productServiceClient;

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.listAll();
        return orders.stream()
                .map(this::enrichOrderWithDetails)
                .collect(Collectors.toList());
    }

    public Order getOrderById(Long id) {
        return Optional.ofNullable(orderRepository.findById(id))
                .map(this::enrichOrderWithDetails)
                .orElseThrow(() -> new WebApplicationException("Order not found", 404));
    }

    @Transactional
    public Order createOrder(Order order) {
        validateOrder(order);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.persist(order);
        return enrichOrderWithDetails(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order order) {
        validateOrder(order);

        return Optional.ofNullable(orderRepository.findById(id))
                .map(existingOrder -> {
                    existingOrder.setQuantity(order.getQuantity());
                    existingOrder.setOrderDate(order.getOrderDate());
                    orderRepository.persist(existingOrder);
                    return enrichOrderWithDetails(existingOrder);
                })
                .orElseThrow(() -> new WebApplicationException("Order not found", 404));
    }

    @Transactional
    public void deleteOrder(Long id) {
        Optional.ofNullable(orderRepository.findById(id))
                .ifPresentOrElse(orderRepository::delete,
                        () -> { throw new WebApplicationException("Order not found", 404); });
    }

    public List<Order> getOrdersByClientId(Long clientId) {
        if (clientId == null) {
            throw new WebApplicationException("Client ID is required", 400);
        }

        List<Order> orders = orderRepository.getOrderByIdClient(clientId);

        if (orders.isEmpty()) {
            throw new WebApplicationException("No orders found for client ID " + clientId, 404);
        }

        return orders.stream()
                .map(this::enrichOrderWithDetails)
                .collect(Collectors.toList());
    }

    private Order enrichOrderWithDetails(Order order) {
        if (order != null) {
            ClientDTO client = clientServiceClient.getClient(order.getClientId());
            ProductDTO product = productServiceClient.getProduct(order.getProductId());

            if (client == null) {
                throw new WebApplicationException("Client not found for ID " + order.getClientId(), 404);
            }

            if (product == null) {
                throw new WebApplicationException("Product not found for ID " + order.getProductId(), 404);
            }

            order.setClientDTO(client);
            order.setProductDTO(product);
        }
        return order;
    }

    private void validateOrder(Order order) {
        if (order == null) {
            throw new WebApplicationException("Order cannot be null", 400);
        }

        if (order.getClientId() == null) {
            throw new WebApplicationException("Client ID cannot be null", 400);
        }

        if (order.getProductId() == null) {
            throw new WebApplicationException("Product ID cannot be null", 400);
        }

        if (order.getQuantity() <= 0) {
            throw new WebApplicationException("Quantity must be greater than 0", 400);
        }
    }
}
