package com.nhom10.repository;

import com.nhom10.model.Salary;
import com.nhom10.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> countAllByTrip(Trip trip);
}
