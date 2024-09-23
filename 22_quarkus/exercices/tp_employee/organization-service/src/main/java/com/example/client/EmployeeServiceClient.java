package com.example.client;

import com.example.dto.EmployeeDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/employees")
@RegisterRestClient(configKey = "employee-service")
public interface EmployeeServiceClient {

    @GET
    @Path("/organization/{organizationId}")
    List<EmployeeDTO> getEmployeesByOrganizationId(@PathParam("organizationId") Long organizationId);

    @GET
    @Path("/organization/{organizationId}/count")
    Long countEmployeesByOrganizationId(@PathParam("organizationId") Long organizationId);

}