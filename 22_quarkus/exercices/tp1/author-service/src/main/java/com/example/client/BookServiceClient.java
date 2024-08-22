package com.example.client;

import com.example.dto.BookDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/books")
@RegisterRestClient(configKey = "book-service")
public interface BookServiceClient {

    @GET
    @Path("/author/{id}")
    List<BookDTO> findBooksByAuthorId(@PathParam("id") Long id);

}
