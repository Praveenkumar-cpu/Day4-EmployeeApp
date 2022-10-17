package com.bridgelabz.employeepayroleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    @NotEmpty(message = "Name Cannot Empty")
@Pattern(regexp = "[A-Z]{1}]",message = "Enter Valid Name")
    public String name;
    @Min(value = 500,message = "Salary Should Be Greater then 500Ru")
    public long salary;

    //here im not using getter and setter bez of @data
    //not using parameterized constructor bez of @AllArgsConstructor



}
