package org.example.kafka;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.example.util.constant.OrderStatus;

@ApplicationScoped
public class OrderKafkaConsumer {

    @Inject
    OrderService orderService;

    @Incoming("check-balance")
    @Transactional
    public void onCheckBalance(String message) {
        System.out.println("event ok");
        System.out.println(message);
        String[] explodedMessage = message.split(" ");
        long orderId = Long.parseLong(explodedMessage[0]);
        boolean check = explodedMessage[1].equals("1");
        System.out.println(check);
        Order order = orderService.getOrderById(orderId);
        order.setOrderStatus(check ? OrderStatus.CONFIRMED : OrderStatus.REJECTED);
        orderService.updateOrder(orderId, order);
    }
}
