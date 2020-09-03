package com.nhom10.repository;

import com.nhom10.model.Employee;
import com.nhom10.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    Optional<Trip> findByGuestNumber(int number);
    Optional<Trip> findByPrice(float price);

}
