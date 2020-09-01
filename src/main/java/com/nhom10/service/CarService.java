package com.nhom10.service;

import com.nhom10.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(Long id);
    void save(Car car);
    void remove(Long id);
}
