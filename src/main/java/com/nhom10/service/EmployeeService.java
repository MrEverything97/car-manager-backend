package com.nhom10.service;

import com.nhom10.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    void save(Employee employee);
    void remove(Long id);
    List<Employee> findByName(String name);
    Optional<Employee> findByCard(Long card);
}
