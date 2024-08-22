package com.example.client;

import com.example.dto.AuthorDTO;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/authors")
@RegisterRestClient(configKey = "author-service")
public interface AuthorServiceClient {

    @GET
    @Path("/{id}")
    AuthorDTO getAuthorById(@PathParam("id") Long id);

    @POST
    AuthorDTO createAuthor(AuthorDTO authorDTO);
}
