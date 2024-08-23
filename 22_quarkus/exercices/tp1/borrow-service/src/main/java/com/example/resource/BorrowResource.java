package com.example.resource;

import com.example.entity.Borrow;
import com.example.service.BorrowService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
    @Path("/{id}")
    public Response getBorrow(@PathParam("id") Long id) {
        return Response.ok(borrowService.getBorrowById(id)).build();
    }

    @GET
    @Path("/user/{userId}") // recherche par utilisateur
    public Response getUserBorrows(@PathParam("userId") Long userId) {
        return Response.ok(borrowService.getBorrowsByUserId(userId)).build();
    }

    @GET
    @Path("/book/{bookId}") // recherche par livre
    public Response getBookBorrows(@PathParam("bookId") Long bookId) {
        return Response.ok(borrowService.getBorrowsByBookId(bookId)).build();
    }

    @GET
    @Path("/date-between/{from}/{to}")
    public Response getDateBetween(@PathParam("from") String from, @PathParam("to") String to) {
        return Response.ok(borrowService.getBorrowsBetweenDate(from, to)).build();
    }

    @GET
    @Path("/current-borrows") // prêts en cours
    public Response getCurrentBorrows() {
        return Response.ok(borrowService.getNotReturnedBorrows()).build();
    }

    @POST
    @Path("/open/{userId}/{bookId}") // créer un nouvel emprunt
    public Response createBorrow(@PathParam("userId") Long userId, @PathParam("bookId") Long bookId) {
        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBookId(bookId);
        return Response
                .status(Response.Status.CREATED)
                .entity(borrowService.createBorrow(borrow)).build();
    }

    @POST
    @Path("/return/{id}") // définir un emprunt comme terminé
    public Response closeBorrow(@PathParam("id") Long id) {
        return Response.ok(borrowService.closeBorrow(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBorrow(@PathParam("id") Long id) {
        borrowService.deleteBorrow(id);
        return Response.noContent().build();
    }
}
