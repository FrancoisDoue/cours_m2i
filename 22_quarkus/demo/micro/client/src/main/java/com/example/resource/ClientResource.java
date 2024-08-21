package com.example.resource;

import com.example.entity.Client;
import com.example.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    public Response getClients() {
        return Response.ok(clientService.getClients()).build();
    }

    @POST
    public Response createClient(Client client) {
        return Response.status(Response.Status.CREATED)
                .entity(clientService.createClient(client))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getClient(@PathParam("id") Long id) {
        return clientService.getClientById(id)
                .map(c -> Response.ok(c).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Long id, Client client) {
        return Response.ok(clientService.updateClient(id, client)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id) {
        clientService.deleteClient(id);
        return Response.noContent().build();
    }

}
