package com.learning.CI_CD.controller;

import com.learning.CI_CD.model.Employee;
import com.learning.CI_CD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity(employeeRepository.findAll(), HttpStatus.ACCEPTED);
    }
    @PostMapping("/emp")
    public String addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Added";
    }
}
