package com.smartroom.api;

import com.smartroom.models.Sensor;
import com.smartroom.services.SensorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

public class RoomSensorResource {

    private String roomId;

    public RoomSensorResource(String roomId) {
        this.roomId = roomId;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getSensorsForRoom() {
        // Filters global sensors to only show those belonging to this specific room
        return SensorService.getAllSensors().stream()
                .filter(s -> s.getRoomId().equals(roomId))
                .collect(Collectors.toList());
    }
}