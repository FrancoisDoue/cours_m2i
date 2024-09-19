package org.example;



import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Authenticated
public class ClientResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    ClientService clientService;

    @GET
    @RolesAllowed("client")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GET
    @Path("/{id}")
    public Client getClientById(@PathParam("id") Long id) {
        return clientService.getClientById(id);
    }

    @POST
    public Client createClient(Client client) {
        return clientService.createClient(client);
    }

    @PUT
    @Path("/{id}")
    public Client updateClient(@PathParam("id") Long id, Client client) {
        return clientService.updateClient(id, client);
    }

    @DELETE
    @Path("/{id}")
    public void deleteClient(@PathParam("id") Long id) {
        clientService.deleteClient(id);
    }
}

