package com.bridgelabz.employeepayroleapp.model;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// this is a model we to save in repository
@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollData {
@Id
@GeneratedValue
    private int employeeId;
    private String name;
    private long salary;


    public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
    }
}
