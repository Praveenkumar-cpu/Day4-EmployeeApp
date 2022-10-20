package com.bridgelabz.employeepayroleapp.services;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroleapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayroleapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayroleapp.repository.EmployeePayrollRepository;
import com.bridgelabz.employeepayroleapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService{

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee not found for id "+empId));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        employeePayrollRepository.save(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepository.deleteById(empId);

    }

    @Override
    public List<EmployeePayrollData> findEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}
