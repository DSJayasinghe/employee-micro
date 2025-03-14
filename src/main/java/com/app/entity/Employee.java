package com.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_table")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name") //represent the column of the table
    private String employeeName;

    @Column(name = "employee_address") //represent the column of the table
    private String employeeAddress;

    @Column(name = "employee_tel") //represent the column of the table
    private String employeeTel;

    @Column(name = "employee_password") //represent the column of the table
    private String employeePassword;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(String employeeTel) {
        this.employeeTel = employeeTel;
    }

    public String getPassword() {
        return employeePassword;
    }

    public void setPassword(String password) {
        this.employeePassword = password;
    }
}

