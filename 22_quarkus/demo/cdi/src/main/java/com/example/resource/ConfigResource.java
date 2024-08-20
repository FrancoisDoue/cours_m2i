package com.example.resource;

import com.example.configProperty.AppConfigService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class ConfigResource {
    @Inject
    AppConfigService appConfigService;

    @GET
    @Path("/message")
    public String getMessage() {
        return "Message : "+ appConfigService.getMessage();
    }

    @GET
    @Path("/version")
    public String getVersion() {
        return "Version : "+ appConfigService.getVersion();
    }

    @GET
    @Path("/value")
    public String getDefaultValue() {
        return "Default value : "+ appConfigService.getDefaultValue();
    }
}
