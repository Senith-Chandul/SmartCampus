package com.smartroom.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/")
public class DiscoveryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("version", "1.0");
        info.put("student_name", "Senith Chandul Sagarage");
        info.put("student_id", "w2120309");
        info.put("student_email", "senith.20231705@iit.ac.lk");
        info.put("status", "API Online");
        
        // HATEOAS: Providing links to resources
        Map<String, String> links = new HashMap<>();
        links.put("rooms", "/api/v1/rooms");
        links.put("sensors", "/api/v1/sensors");
        info.put("links", links);
        
        return Response.ok(info).build();
    }
}