package com.example.client;

import com.example.dto.DepartmentDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/departments")
@RegisterRestClient(configKey = "department-service")
public interface DepartmentServiceClient {

    @GET
    @Path("/{id}")
    DepartmentDTO getDepartmentById(@PathParam("id") Long id);
}
