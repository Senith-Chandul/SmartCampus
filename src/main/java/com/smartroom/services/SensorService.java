package com.smartroom.services;

import com.smartroom.models.Sensor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SensorService {
    private static final Map<String, Sensor> sensorDatabase = new ConcurrentHashMap<>();

    public static List<Sensor> getAllSensors() {
        return new ArrayList<>(sensorDatabase.values());
    }

    public static void addSensor(Sensor sensor) {
        sensorDatabase.put(sensor.getId(), sensor);
    }

    public static Sensor getSensorById(String id) {
        return sensorDatabase.get(id);
    }

    public static List<Sensor> getSensorsByType(String type) {
        return sensorDatabase.values().stream()
                .filter(s -> s.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}