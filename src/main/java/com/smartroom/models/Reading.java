package com.smartroom.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
public class Reading {
    private double value;
    private String timestamp;

    public Reading() {
        // Automatically sets the timestamp when a reading is created
        this.timestamp = LocalDateTime.now().toString();
    }

    public Reading(double value) {
        this();
        this.value = value;
    }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}