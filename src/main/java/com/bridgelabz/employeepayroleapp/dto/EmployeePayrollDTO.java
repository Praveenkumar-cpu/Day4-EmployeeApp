package com.bridgelabz.employeepayroleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {

    public String name;
    public long salary;

    //here im not using getter and setter bez of @data
    //not using parameterized constructor bez of @AllArgsConstructor



}
