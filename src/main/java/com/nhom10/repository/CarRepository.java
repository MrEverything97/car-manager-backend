package com.nhom10.repository;

import com.nhom10.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByColorContainingIgnoreCase(String color);
    List<Car> findByLicensePlateContainingIgnoreCase(String lp); // tach ra 2 nhanh
    List<Car> findByManufacturedContainingIgnoreCase(String mf);
}