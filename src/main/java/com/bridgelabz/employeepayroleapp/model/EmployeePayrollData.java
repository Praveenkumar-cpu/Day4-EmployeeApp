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
@ToString
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn (name = "id"))
    public List<String> departments;


    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.name = empPayrollDTO.getName();
        this.salary = empPayrollDTO.getSalary();
        this.gender = empPayrollDTO.getGender();
        this.startDate = empPayrollDTO.getStartDate();
        this.note = empPayrollDTO.getNote();
        this.profilePic = empPayrollDTO.getProfilePic();
        this.departments = empPayrollDTO.getDepartments();

    }

}
