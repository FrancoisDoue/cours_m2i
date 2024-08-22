package com.example.resource;

import com.example.entity.Author;
import com.example.service.AuthorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @Inject
    AuthorService authorService;

    @GET
    public Response getAuthors() {
        return Response.ok(authorService.getAuthors()).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthor(@PathParam("id") Long id) {
        return Response.status(Response.Status.CREATED)
                .entity(authorService.getAuthorById(id))
                .build();
    }

    @POST
    public Response createAuthor(Author author) {
        return Response.ok(authorService.createAuthor(author)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") Long id) {
        authorService.deleteAuthor(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") Long id, Author author) {
        return Response.ok(authorService.updateAuthor(id, author)).build();
    }

}
