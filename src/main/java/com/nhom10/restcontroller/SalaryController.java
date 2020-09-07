package com.nhom10.restcontroller;

import com.nhom10.model.Salary;
import com.nhom10.model.Salary;
import com.nhom10.model.Trip;
import com.nhom10.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;
//    @GetMapping("/salary")
//    public ResponseEntity<List<Salary>> showListSalary(){
//        List<Salary>salaryList;
//        salaryList = salaryService.countEmployee();
//        if (salaryList.isEmpty()){
//            return new ResponseEntity<List<Salary>>(HttpStatus.NOT_FOUND);
//        }else {
//            return new ResponseEntity<List<Salary>>(salaryList, HttpStatus.OK);
//        }
//    }
}
