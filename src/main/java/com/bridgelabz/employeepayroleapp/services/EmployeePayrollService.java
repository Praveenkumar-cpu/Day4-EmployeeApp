package com.bridgelabz.employeepayroleapp.services;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroleapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayroleapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayroleapp.repository.EmployeePayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    EmployeePayrollRepo employeePayrollRepo;


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepo.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
//        Optional<EmployeePayrollData>employeePayrollData = employeePayrollRepo.findById(empId);
//        if (employeePayrollData.isPresent())
//        return employeePayrollData.get();
//        return null;


        return employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee not found for id "+empId));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        employeePayrollRepo.save(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
        Optional<EmployeePayrollData>employeePayrollData = employeePayrollRepo.findById(empId);
        if (employeePayrollData.isPresent()){
            EmployeePayrollData data1 = employeePayrollData.get();
            data1.setName(empPayrollDTO.name);
            data1.setSalary(empPayrollDTO.salary);
            employeePayrollRepo.save(data1);
        }
        return null;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepo.deleteById(empId);

    }
}
