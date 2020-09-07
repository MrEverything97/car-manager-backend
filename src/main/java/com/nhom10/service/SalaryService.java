package com.nhom10.service;

import com.nhom10.model.Salary;
import com.nhom10.model.Trip;

import java.util.List;
import java.util.Optional;

public interface SalaryService {
    List<Salary> findAll();
    Optional<Salary> findById(Long id);
    void save(Salary salary);
    void remove(Long id);
//    List<Salary> countEmployee();
}
