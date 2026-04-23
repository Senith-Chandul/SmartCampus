package com.smartroom.api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api/v1")
public class RestConfig extends Application {
    // This empty class triggers the API at /api/v1
}