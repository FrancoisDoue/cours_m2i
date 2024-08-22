package com.example.resource;

import com.example.entity.Book;
import com.example.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Response getBooks() {
        return Response.ok(bookService.getBooks()).build();
    }

    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") Long id) {
        return Response.ok(bookService.getBookById(id)).build();
    }

    @GET
    @Path("/author/{authorId}")
    public Response getBookByAuthor(@PathParam("authorId") Long authorId) {
        return Response.ok(bookService.getBooksByAuthorId(authorId)).build();
    }

//    @POST
//    @Path("/borrow/{id}")
//    public Response borrowBook(@PathParam("id") Long id) {
//        return Response.ok()
//    }


    @POST
    public Response createBook(Book book) {
        return Response.status(Response.Status.CREATED)
                .entity(bookService.createBook(book))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, Book book) {
        return Response.ok(bookService.updateBook(book.getId(), book)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        bookService.deleteBook(id);
        return Response.noContent().build();
    }

}
