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
//        Optional<EmployeePayrollData>employeePayrollData = employeePayrollRepo.findById(empId);
//        if (employeePayrollData.isPresent())
//        return employeePayrollData.get();
//        return null;


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
        Optional<EmployeePayrollData>employeePayrollData = employeePayrollRepository.findById(empId);
        if (employeePayrollData.isPresent()){
            EmployeePayrollData data1 = employeePayrollData.get();
            data1.setName(empPayrollDTO.name);
            data1.setSalary(empPayrollDTO.salary);
            employeePayrollRepository.save(data1);
        }
        return null;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepository.deleteById(empId);

    }
}
