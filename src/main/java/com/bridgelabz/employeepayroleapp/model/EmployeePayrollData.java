package com.bridgelabz.employeepayroleapp.model;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

// this is a model we to save in repository
@Entity
@Table(name = "employee")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class EmployeePayrollData {
@Id
@GeneratedValue
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;

    private String note;
    private String profilePic;

    @ElementCollection
    public List<String> departments;


    public EmployeePayrollData(int employeeId,EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {

    }

    public EmployeePayrollData() {

    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.departments;
    }

}
