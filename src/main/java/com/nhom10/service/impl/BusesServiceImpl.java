package com.nhom10.service.impl;

import com.nhom10.model.Buses;
import com.nhom10.repository.BusesRepository;
import com.nhom10.service.BusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusesServiceImpl implements BusesService {
    @Autowired
    private BusesRepository busesRepository;

    @Override
    public List<Buses> findAll() {
        return busesRepository.findAll();
    }

    @Override
    public Optional<Buses> findById(Long id) {
        return busesRepository.findById(id);
    }

    @Override
    public void save(Buses buses) {
        busesRepository.save(buses);
    }

    @Override
    public void remove(Long id) {
        busesRepository.deleteById(id);
    }
}
