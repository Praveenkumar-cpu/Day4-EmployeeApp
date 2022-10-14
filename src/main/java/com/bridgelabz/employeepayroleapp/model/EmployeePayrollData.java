package com.bridgelabz.employeepayroleapp.model;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;

// this is a model we to save in repository
public class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    // here im passing constructor obj called  EmployeePayrollDTO

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
