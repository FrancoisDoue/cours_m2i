package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Book;
import org.example.repository.BookRepository;

import java.net.URI;

@Path("/api/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource1 {

    @Inject
    BookRepository bookRepository;

    @GET
    @Path("/about")
    @Produces(MediaType.TEXT_HTML)
    public String about() {
        return "<html><body><h1>About</h1><p>This is a book about</p></body></html>";
    }

    @GET
    @Path("/author")
    public Response author(@QueryParam("author") String author) {
        return Response.ok(bookRepository.findByAuthor(author)).build();
    }
//
//   @GET
//    @Path("/authorization")
//    public Response authorization(@QueryParam("author") String author) {}

    @POST
    @Path("/form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response form(@FormParam("id") int id,
                         @FormParam("title") String title,
                         @FormParam("author") String author,
                         @FormParam("year") int year,
                         @FormParam("genre") String genre) {
        Book book = Book.builder().title(title).author(author).year(year).genre(genre).build();
        return Response.status(Response.Status.CREATED).entity(bookRepository.create(book)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response form(@BeanParam Book book) {
        return Response.status(Response.Status.CREATED).entity(bookRepository.create(book)).build();
    }
}
