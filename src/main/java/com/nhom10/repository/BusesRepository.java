package com.nhom10.repository;

import com.nhom10.model.Buses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusesRepository extends JpaRepository<Buses,Long> {
}
