package com.learning.CI_CD.controller;

import com.learning.CI_CD.model.Employee;
import com.learning.CI_CD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return new ResponseEntity(employeeRepository.findById(id), HttpStatus.OK);
    }

}
