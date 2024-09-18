package org.example.client;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.example.dto.CheckBalanceDto;

@Path("/api/account")
@RegisterRestClient(configKey = "account-service")
public interface AccountServiceClient {

    @GET
    @Path("/balance-check/{idClient}/{amount}")
    CheckBalanceDto checkBalance(@PathParam("idClient") long idClient, @PathParam("amount") double amount);
}
