package com.example.resource;

import com.example.scoped.GlobalRequestCounterService;
import com.example.scoped.RequestCounterService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/counter")
public class CounterResource {
    @Inject
    GlobalRequestCounterService globalRequestCounterService;

    @Inject
    RequestCounterService requestCounterService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String counter() {
        globalRequestCounterService.increment();
        requestCounterService.increment();
        return "Global: " + globalRequestCounterService.getGlobalCounter() +
                " / Request: " + requestCounterService.getRequestCounter();
    }
}
