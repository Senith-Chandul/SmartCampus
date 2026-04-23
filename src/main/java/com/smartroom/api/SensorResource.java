package com.smartroom.api;

import com.smartroom.exceptions.*;
import com.smartroom.models.Reading;
import com.smartroom.models.Sensor;
import com.smartroom.services.RoomService;
import com.smartroom.services.SensorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/sensors")
public class SensorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getSensors(@QueryParam("type") String type) {
        if (type != null && !type.isEmpty()) {
            return SensorService.getSensorsByType(type);
        }
        return SensorService.getAllSensors();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSensor(Sensor s) {
        if (RoomService.getRoom(s.getRoomId()) == null) {
            throw new LinkedResourceNotFoundException("Room ID " + s.getRoomId() + " does not exist.");
        }
        SensorService.addSensor(s);
        return Response.status(201).entity(s).build();
    }

    @POST
    @Path("/{id}/readings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReading(@PathParam("id") String id, Reading r) {
        Sensor s = SensorService.getSensorById(id);
        if (s == null) {
            return Response.status(404).build();
        }

        // Part 5.3: Maintenance Check
        if ("MAINTENANCE".equalsIgnoreCase(s.getStatus())) {
            throw new SensorUnavailableException("Sensor is in MAINTENANCE mode and cannot accept readings.");
        }

        s.addReading(r.getValue());
        return Response.ok(s).build();
    }
}
