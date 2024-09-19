package org.example.resource;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.example.entity.Order;
import org.example.service.OrderService;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Authenticated
public class OrderResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    OrderService orderService;

    @GET
    @RolesAllowed("manager")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{id}")
    public Order getOrderById(@PathParam("id") Long id) {
        return orderService.getOrderById(id);
    }
//
//    @POST
//    public Uni<Order> createOrder(Order order) {
//
////        orderService.createOrder(order);
//        return Uni.createFrom().item(() -> orderService.createOrder(order)).runSubscriptionOn(Infrastructure.getDefaultExecutor());
//    }

    @POST
    public Order createOrder(Order order) {

//        orderService.createOrder(order);
        return orderService.createOrder(order);
    }

    @PUT
    @Path("/{id}")
    public Order updateOrder(@PathParam("id") Long id, Order order) {
        return orderService.updateOrder(id, order);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") Long id) {
        orderService.deleteOrder(id);
    }


    @GET
    @Path("/client/{clientId}")
    public List<Order> getOrdersByClientId(@PathParam("clientId") Long clientId) {
        return orderService.getOrdersByClientId(clientId);
    }

}