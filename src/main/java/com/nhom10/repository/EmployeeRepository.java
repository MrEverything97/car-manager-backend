package com.nhom10.repository;

import com.nhom10.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByFullNameContainingIgnoreCase(String name);
    List<Employee> findByIdCardContainingOrIdLicenseContaining(int idCard,int idLicense);
}
