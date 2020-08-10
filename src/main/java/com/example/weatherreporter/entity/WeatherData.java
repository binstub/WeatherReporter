package com.example.weatherreporter.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection="weatherdata")
public class WeatherData {
    @Id
    private String id;

    @Indexed
    private LocalDate date;
    private Location location;
    private double[] temperature;

    public WeatherData(String id, LocalDate date, Location location, double[] temperature) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {this.date = date; }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

}
