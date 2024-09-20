package com.example.client;

import com.example.dto.OrganizationDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/organizations")
@RegisterRestClient(configKey = "organization-service")
public interface OrganizationServiceClient {

    @GET
    @Path("/{id}")
    OrganizationDTO getOrganizationById(@PathParam("id") Long id);
}
