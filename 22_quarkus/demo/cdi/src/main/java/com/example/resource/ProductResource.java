package com.example.resource;

import com.example.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Path("/pg")
    public Response getPgProducts() {
        productService.printPostgresProducts();
        return Response.noContent().build();
    }

    @GET
    @Path("/mysql")
    public Response getMysqlProducts() {
        productService.printMySQLProducts();
        return Response.noContent().build();
    }

}
