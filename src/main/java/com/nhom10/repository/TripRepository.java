package com.nhom10.repository;

import com.nhom10.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
