package com.example.resource;

import com.example.service.BorrowService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/borrows")
public class BorrowResource {

    @Inject
    BorrowService borrowService;

    @GET
    public Response getBorrows() {
        return Response.ok(borrowService.getBorrows()).build();
    }

    @GET
    @Path("/user/{userId}")
    public Response getUserBorrows(@PathParam("userId") Long userId) {
        return Response.ok(borrowService.getBorrowsByUserId(userId)).build();
    }

    @GET
    @Path("/book/{bookId}")
    public Response getBookBorrows(@PathParam("bookId") Long bookId) {
        return Response.ok(borrowService.getBorrowsByBookId(bookId)).build();
    }
}
