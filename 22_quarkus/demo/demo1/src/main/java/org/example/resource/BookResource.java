package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.jboss.logging.Logger;

import java.util.HashMap;
import java.util.Map;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

    @GET
    public Response getBooks() {
        logger.info("getBooks");
        return Response.ok().entity(bookRepository.getAll()).build();
    }

    @GET
    @Path("/count")
    public Response getBookCount() {
        logger.info("getBookCount");
        return Response.ok().entity(
                new HashMap<>(Map.of("count", bookRepository.getAll().size()))
        ).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        logger.info("addBook");
        return Response.status(Response.Status.CREATED)
                .entity(bookRepository.create(book))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") int id) {
        logger.info("getBook id: " + id);
        return Response.ok().entity(bookRepository.get(id).orElse(null)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") int id, Book book) {
        logger.info("updateBook id: " + id);
        return Response.ok().entity(bookRepository.update(id, book)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        logger.info("deleteBook id: " + id);
        bookRepository.delete(id);
        return Response.noContent().build();
    }
}
