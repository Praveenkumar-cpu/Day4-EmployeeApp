package com.bridgelabz.employeepayroleapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public @ToString class EmployeePayrollDTO {
    @NotEmpty(message = "Name Cannot Empty")
    @Pattern(regexp = "^[A-Z]{1}+[a-z]{3,}$",message = "Enter Valid Name")
    public String name;
    @Min(value = 500,message = "Salary Should Be Greater then 500Ru")
    public long salary;

    //here im not using getter and setter bez of @data
    //not using parameterized constructor bez of @AllArgsConstructor

    @Pattern(regexp = "male|female",message = "Gender need to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MMM yyy")
    @NotNull(message = "starDate Should Not be Empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String note;
    @NotNull(message = "profilePic cannot Not be Empty")
    public String profilePic;

    @NotNull(message = "department sould Not be Empty")
    public List<String> departments;



}
