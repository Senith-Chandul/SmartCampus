package com.smartroom.services;

import com.smartroom.models.Room;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RoomService {
    // This is your "Database"
    private static final Map<String, Room> rooms = new ConcurrentHashMap<>();

    public static List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public static Room getRoom(String id) {
        return rooms.get(id);
    }

    public static void addRoom(Room room) {
        rooms.put(room.getId(), room);
    }

    public static boolean deleteRoom(String id) {
        return rooms.remove(id) != null;
    }
}