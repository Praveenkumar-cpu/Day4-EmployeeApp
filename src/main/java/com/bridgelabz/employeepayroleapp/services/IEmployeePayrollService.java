package com.bridgelabz.employeepayroleapp.services;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroleapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);

}
