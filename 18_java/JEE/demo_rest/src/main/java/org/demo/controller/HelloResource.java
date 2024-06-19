package org.demo.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {
    @GET
//    @Produces("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
//        return "{\"hello\" : \"Hello, World!\"}";
        return "Hello World";
    }
}