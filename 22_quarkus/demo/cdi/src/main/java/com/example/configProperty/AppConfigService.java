package com.example.configProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class AppConfigService {

    @Inject
    @ConfigProperty(name = "app.message")
    String message;

    @Inject
    @ConfigProperty(name = "app.version")
    String version;

    @Inject
    @ConfigProperty(name = "app.default.value", defaultValue = "Rohlooo")
    String defaultValue;

    public String getMessage() {
        return message;
    }

    public String getVersion() {
        return version;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

}
