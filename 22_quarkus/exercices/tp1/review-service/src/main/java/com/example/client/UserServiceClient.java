package com.example.client;

import com.example.dto.UserDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/users")
@RegisterRestClient(configKey = "user-service")
public interface UserServiceClient {

    @GET
    @Path("/{id}")
    UserDTO getUser(@PathParam("id") Long id);

    @GET
    @Path("/username/{username}")
    UserDTO getUserByUsername(@PathParam("username") String username);
}
