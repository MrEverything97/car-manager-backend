package com.nhom10.service;

import com.nhom10.model.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {
    List<Trip> findAll();
    Optional<Trip> findById(Long id);
    void save(Trip trip);
    void remove(Long id);
    Optional<Trip> findByGuestNumber(int id);
    Optional<Trip> findByPrice(float id);
}
