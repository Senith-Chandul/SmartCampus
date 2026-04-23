package com.smartroom.models;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room {
    private String id;
    private String name;
    private String description;

    public Room() {} // Needed for JSON conversion

    public Room(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters are MANDATORY
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}