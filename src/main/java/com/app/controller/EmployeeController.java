package com.app.controller;

import com.app.entity.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173/")
@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee registerEmployee(@RequestBody Employee employee)
    {
        return employeeService.registerEmployee(employee);
    }

    @GetMapping(path = "/employees")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping(path ="/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping(path="/employees/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping(path ="/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    //login
    @GetMapping(path="/employees", params={"name", "password"})
    public ResponseEntity<Employee> employeeLogin(@RequestParam String name, @RequestParam String password) {
        Employee employee = employeeService.employeeLogin(name, password);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

