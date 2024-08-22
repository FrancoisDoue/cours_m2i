package com.example.client;

import com.example.dto.ClientDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/clients")
@RegisterRestClient(configKey = "client-service")
public interface ClientServiceClient {

    @GET
    @Path("/{id}")
    ClientDTO getClient(@PathParam("id") Long id);
}
