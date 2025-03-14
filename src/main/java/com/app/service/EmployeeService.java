package com.app.service;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public Employee registerEmployee(Employee employee)
    {return employeeRepository.save(employee);}

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }
        return null;
    }

    public Employee updateEmployee(int id,Employee employee){
        Optional<Employee> emp = employeeRepository.findById(id);

        if(emp.isPresent()){
            Employee existingEmp = emp.get();
            existingEmp.setEmployeeName(employee.getEmployeeName());
            existingEmp.setEmployeeAddress(employee.getEmployeeAddress());
            existingEmp.setEmployeeTel(employee.getEmployeeTel());
            employeeRepository.save(existingEmp);
            return existingEmp;
        }
        return employee;
    }

    public Employee deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return null;
    }

    public Employee employeeLogin(String name, String password) {
        return employeeRepository.employeeLogin(name,password);
    }

}
