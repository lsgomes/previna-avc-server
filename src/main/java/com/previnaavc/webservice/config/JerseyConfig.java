package com.previnaavc.webservice.config;

import com.previnaavc.webservice.RestEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super();
        register(RestEndpoint.class);
    }

}