package com.smartroom.filters;

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    private static final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext req) throws IOException {
        // Log Method and URI
        LOG.info(">>> REQUEST: " + req.getMethod() + " " + req.getUriInfo().getAbsolutePath());
    }

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
        // Log Status Code
        LOG.info("<<< RESPONSE STATUS: " + res.getStatus());
    }
}