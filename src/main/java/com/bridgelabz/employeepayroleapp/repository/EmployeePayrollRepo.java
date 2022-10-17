package com.bridgelabz.employeepayroleapp.repository;

import com.bridgelabz.employeepayroleapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepo extends JpaRepository<EmployeePayrollData,Integer> {

}
