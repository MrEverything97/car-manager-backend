package com.nhom10.service.impl;

import com.nhom10.model.Salary;
import com.nhom10.model.Trip;
import com.nhom10.repository.SalaryRepository;
import com.nhom10.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    @Override
    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    @Override
    public Optional<Salary> findById(Long id) {
        return salaryRepository.findById(id);
    }

    @Override
    public void save(Salary salary) {
        salaryRepository.save(salary);
    }

    @Override
    public void remove(Long id) {
        salaryRepository.deleteById(id);
    }

    @Override
    public List<Salary> countTrip(Trip trip) {
        return salaryRepository.countAllByTrip(trip);
    }
}
