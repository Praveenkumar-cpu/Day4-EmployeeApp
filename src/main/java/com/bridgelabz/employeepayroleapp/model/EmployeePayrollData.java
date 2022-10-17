package com.bridgelabz.employeepayroleapp.model;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// this is a model we to save in repository
@Entity
@Table(name = "Employee")
public class EmployeePayrollData {
@Id
@GeneratedValue
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    // here im passing constructor obj called  EmployeePayrollDTO


    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

    public EmployeePayrollData(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {

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
