package com.nhom10.model;

import javax.persistence.*;


//Chuyen xe
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Buses buses;// Tuyen xe
    @ManyToOne
    private Employee driver;//tai xe
    @ManyToOne
    private Employee subDriver; //phu xe
    private int guestNumber; // so luong khach
    private float price;// gia ve
    @ManyToOne
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Trip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buses getBuses() {
        return buses;
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public Employee getDriver() {
        return driver;
    }

    public void setDriver(Employee driver) {
        this.driver = driver;
    }

    public Employee getSubDriver() {
        return subDriver;
    }

    public void setSubDriver(Employee subDriver) {
        this.subDriver = subDriver;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
