package com.example.resource;

import com.example.entity.Order;
import com.example.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @GET
    public Response getOrders() {
        return Response.ok(orderService.getAllOrders()).build();
    }

    @GET
    @Path("/client/{clientId}")
    public Response getOrdersByClientId(@PathParam("clientId") Long clientId) {
        return Response.ok(orderService.getOrdersByClientId(clientId)).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrderById(@PathParam("id") Long id) {
        return Response.ok(orderService.getOrderById(id)).build();
    }

    @POST
    public Response makeOrder(Order order) {
        return Response.status(Response.Status.CREATED)
                .entity(orderService.createOrder(order))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrder(@PathParam("id") Long id, Order order) {
        return Response.ok(orderService.updateOrder(id, order)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        orderService.deleteOrder(id);
        return Response.noContent().build();
    }
}
