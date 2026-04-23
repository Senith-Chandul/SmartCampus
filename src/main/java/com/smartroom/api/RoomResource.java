package com.smartroom.api;

import com.smartroom.exceptions.RoomNotEmptyException;
import com.smartroom.models.Room;
import com.smartroom.services.RoomService;
import com.smartroom.services.SensorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/rooms")
public class RoomResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAll() {
        return RoomService.getAllRooms();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") String id) {
        Room r = RoomService.getRoom(id);
        if (r == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(r).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Room room, @Context UriInfo uriInfo) {
        RoomService.addRoom(room);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(room.getId());
        return Response.created(builder.build()).entity(room).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        // Check if room has sensors (Part 5.1 Requirement)
        boolean hasSensors = SensorService.getAllSensors().stream()
                .anyMatch(s -> s.getRoomId().equals(id));

        if (hasSensors) {
            throw new RoomNotEmptyException("Cannot delete: Room is currently occupied by active hardware.");
        }

        if (RoomService.deleteRoom(id)) {
            return Response.noContent().build();
        }
        return Response.status(404).build();
    }

    // Part 4.1: Sub-Resource Locator for /rooms/{id}/sensors
    @Path("/{roomId}/sensors")
    public RoomSensorResource getRoomSensors(@PathParam("roomId") String roomId) {
        return new RoomSensorResource(roomId);
    }
}
