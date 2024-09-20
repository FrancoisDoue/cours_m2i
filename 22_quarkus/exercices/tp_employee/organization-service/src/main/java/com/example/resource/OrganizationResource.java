package com.example.resource;

import com.example.entity.Organization;
import com.example.service.OrganizationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/api/organizations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationResource {

    @Inject
    OrganizationService organizationService;

    @GET
    public Response getOrganizations() {
        return Response.ok(organizationService.getAllOrganizations()).build();
    }

    @POST
    public Response addOrganization(Organization organization) {
        return Response.status(Response.Status.CREATED)
                .entity(organizationService.createOrganization(organization)).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrganization(@PathParam("id") Long id, @QueryParam("detail") Boolean detail) {
        if (detail != null && detail) {
            return Response.ok(organizationService.getDetailedOrganizationById(id)).build();
        }
        return Response.ok(organizationService.getOrganizationById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrganization(@PathParam("id") Long id, Organization organization) {
        return Response.ok(organizationService.updateOrganization(id, organization)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganization(@PathParam("id") Long id) {
        organizationService.deleteOrganization(id);
        return Response.noContent().build();
    }

}
