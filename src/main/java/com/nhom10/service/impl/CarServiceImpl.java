package com.nhom10.service.impl;

import com.nhom10.model.Car;
import com.nhom10.repository.CarRepository;
import com.nhom10.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void remove(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findByColor(String color) {
        return carRepository.findByColorContainingIgnoreCase(color);
    }

    @Override
    public Optional<Car> findByLicensePlate(String lp) {
        return carRepository.findByLicensePlateContainingIgnoreCase(lp);
    }

    @Override
    public List<Car> findByManufactured(String mf) {
        return carRepository.findByManufacturedContainingIgnoreCase(mf);
    }
}
