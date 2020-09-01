package com.nhom10.repository;

import com.nhom10.model.Buses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BusesRepository extends JpaRepository<Buses,Long> {
    List<Buses> findByStartLocationContainingOrEndLocationContainingIgnoreCase(String sLocation, String eLocation);
    Optional<Buses> findByDistance(Long d);
}
