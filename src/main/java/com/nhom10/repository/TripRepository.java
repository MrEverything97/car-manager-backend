package com.nhom10.repository;

import com.nhom10.model.Employee;
import com.nhom10.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByGuestNumberContaining(int number);
    List<Trip> findByPriceContaining(float price);
}
