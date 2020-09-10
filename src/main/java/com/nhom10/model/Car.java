package com.nhom10.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate; // Bien so xe
    private String color;
    private String manufactured; // hang sx
    private String model;
    private String yearManufactured;
    private Long seats; // so ghe
    private Long longevity; // so nam sd
    private LocalDate lastMaintenance; // ngay bao duong cuoi cung

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(String yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }

    public Long getLongevity() {
        return longevity;
    }

    public void setLongevity(Long longevity) {
        this.longevity = longevity;
    }

    public LocalDate getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }
}
