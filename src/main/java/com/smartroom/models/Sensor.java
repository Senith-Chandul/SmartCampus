package com.smartroom.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Sensor {
    private String id;
    private String type;
    private double value;
    private String roomId;
    private String status = "ACTIVE"; // Default status
    private List<Reading> history = new ArrayList<>();

    public Sensor() {}

    public Sensor(String id, String type, double value, String roomId) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.roomId = roomId;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Reading> getHistory() { return history; }
    public void setHistory(List<Reading> history) { this.history = history; }

    public void addReading(double newValue) {
        this.history.add(new Reading(newValue));
        this.value = newValue;
    }
}