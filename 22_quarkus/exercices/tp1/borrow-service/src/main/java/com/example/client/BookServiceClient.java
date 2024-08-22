package com.example.client;

import com.example.dto.BookDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/books")
@RegisterRestClient(configKey = "book-service")
public interface BookServiceClient {
    @GET
    @Path("/{bookId}")
    BookDTO getBook(@PathParam("bookId") Long bookId);

    @PUT
    @Path("/{bookId}")
    BookDTO updateBook(@PathParam("bookId") Long bookId, BookDTO book);
}
