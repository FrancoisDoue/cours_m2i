package com.example.resource;

import com.example.service.ReviewService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {

    @Inject
    ReviewService reviewService;

    @GET
    public Response getAllReviews() {
        return Response.ok(reviewService.getReviews()).build();
    }

    @GET
    @Path("/{id}")
    public Response getReviewById(@PathParam("id") Long id) {
        return Response.ok(reviewService.getReview(id)).build();
    }

    @GET
    @Path("/isbn/{isbn}")
    public Response getReviewByIsbn(@PathParam("isbn") String isbn) {
        return Response.ok(reviewService.getReviewsByIsbn(isbn)).build();
    }

    @GET
    @Path("/username/{username}")
    public Response getReviewByUsername(@PathParam("username") String username) {
        return Response.ok(reviewService.getReviewsByUserName(username)).build();
    }

    @GET
    @Path("/notation-higher/{notation}")
    public Response getReviewByNotationHigherThan(@PathParam("notation") Integer notation) {
        return Response.ok(reviewService.getReviewsByNotationHigherThan(notation)).build();
    }

    @GET
    @Path("/notation-lower/{notation}")
    public Response getReviewByNotationLowerThan(@PathParam("notation") Integer notation) {
        return Response.ok(reviewService.getReviewsByNotationLowerThan(notation)).build();
    }

}
