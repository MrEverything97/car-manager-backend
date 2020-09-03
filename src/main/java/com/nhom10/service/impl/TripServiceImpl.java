package com.nhom10.service.impl;

import com.nhom10.model.Trip;
import com.nhom10.repository.TripRepository;
import com.nhom10.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }

    @Override
    public void save(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public void remove(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Optional<Trip> findByGuestNumber(int id) {
        return tripRepository.findByGuestNumber(id);
    }

    @Override
    public Optional<Trip> findByPrice(float id) {
        return tripRepository.findByPrice(id);
    }
}
