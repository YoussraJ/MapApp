package com.example.location;
public class Position {
    private String id;         // Unique identifier (from backend)
    private String name;       // Position name
    private String number;     // Position number
    private double latitude;   // Latitude coordinate
    private double longitude;  // Longitude coordinate

    // Default constructor
    public Position() {
    }

    // Constructor with parameters
    public Position( String name, String number, double latitude, double longitude) {
        this.name = name;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

