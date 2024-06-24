package application.util;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
//        System.out.println("On CorsFilter");
        res.getHeaders().add(
                "Access-Control-Allow-Origin", "*"
        );
//        res.getHeaders().add(
//                "Access-Control-Allow-Credentials", "true"
//        );
        res.getHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization"
        );
        res.getHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, PATCH, DELETE"
        );
    }
}