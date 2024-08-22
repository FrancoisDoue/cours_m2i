package com.example.client;

import com.example.dto.ProductDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/products")
@RegisterRestClient(configKey = "product-service")
public interface ProductServiceClient {

    @GET
    @Path("/{id}")
    ProductDTO getProduct(@PathParam("id") Long id);
}
