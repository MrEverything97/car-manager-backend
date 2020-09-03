package com.nhom10.repository;

import com.nhom10.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByFullNameContainingIgnoreCase(String name);
    Optional<Employee> findByIdCardOrIdLicense(Long idCard, Long idLicense);
}
