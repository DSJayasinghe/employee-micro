package com.app.repository;

import com.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.employeeName=?1 and e.employeePassword=?2")
    public Employee employeeLogin(String name,String password);
}
