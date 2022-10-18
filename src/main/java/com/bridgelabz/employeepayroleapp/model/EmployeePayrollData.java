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
@Column(name = "employee_id")
    private int employeeId;
@Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @Column(name = "department")
    @ElementCollection
    //@CollectionTable(name = "employee_department",joinColumns = @joinColumn(name="id"))
    public List<String> departments;


    public EmployeePayrollData(int employeeId,EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.startDate = empPayrollDTO.startDate;
        this.note = empPayrollDTO.note;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.departments;

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
