package com.nhom10.service;

import com.nhom10.model.Buses;

import java.util.List;
import java.util.Optional;

public interface BusesService {
    List<Buses> findAll();
    Optional<Buses> findById(Long id);
    void save(Buses buses);
    void remove(Long id);
    List<Buses> findByLocation(String location);
    Optional<Buses> findByDistance(Long d);
}
