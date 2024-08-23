package com.example.client;

import com.example.dto.BookDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/books")
@RegisterRestClient(configKey = "book-service")
public interface BookServiceClient {

    @GET
    @Path("/{id}")
    BookDTO getBook(@PathParam("id") Long id);

    @GET
    @Path("/isbn/{isbn}")
    BookDTO getBookIsbn(@PathParam("isbn") String isbn);
}
