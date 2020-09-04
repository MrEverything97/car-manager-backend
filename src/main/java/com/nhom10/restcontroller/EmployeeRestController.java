package com.nhom10.restcontroller;

import com.nhom10.model.Employee;
import com.nhom10.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> showEmployeeList() {
        List<Employee> employeeList;
        employeeList = employeeService.findAll();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        Employee employee1 = employee.get();
        if (employee1 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            employeeService.save(employee1);
            return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> employee1 = employeeService.findById(id);
        Employee employee2 = employee1.get();
        if (employee2 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            employee2.setFullName(employee.getFullName());
            employee2.setIdCard(employee.getIdCard());
            employee2.setIdLicense(employee.getIdLicense());
            employee2.setLicenseType(employee.getLicenseType());
            employee2.setAddress(employee.getAddress());
            employee2.setBirthday(employee.getBirthday());
            employee2.setSeniority(employee.getSeniority());
            employeeService.save(employee2);
            return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            employeeService.remove(id);
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        }
    }

    //tim kiem theo ten nhan vien
    @GetMapping(value = "/find-by-full-name/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable("name") String name) {
        List<Employee> employeeList = employeeService.findByName(name);
        if (employeeList == null) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
        }
    }

    //tim kiem theo ma nhan vien
    @GetMapping(value = "/find-by-id-card/{card}")
    public ResponseEntity<Employee> findBycard(@PathVariable("card") Long card ) {
        Optional<Employee> employee = employeeService.findByCard(card);
        Employee employee1 = employee.get();
        if (employee1 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
        }
    }
}