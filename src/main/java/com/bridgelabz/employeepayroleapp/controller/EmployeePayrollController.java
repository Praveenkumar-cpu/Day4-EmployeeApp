package com.bridgelabz.employeepayroleapp.controller;

import com.bridgelabz.employeepayroleapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroleapp.dto.ResponseDTO;
import com.bridgelabz.employeepayroleapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayroleapp.services.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;


    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList =employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",employeePayrollDataList);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
   {
       EmployeePayrollData employeePayrollData = null;
       employeePayrollData =employeePayrollService.getEmployeePayrollDataById(empId);
       ResponseDTO responseDTO =  new ResponseDTO("Get call success for id",employeePayrollData);
       return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
   }


//    //post method for creating
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> CreateEmployeePayrollData(@Valid  @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        log.debug("Employeee DTO" + empPayrollDTO.toString());
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData =  employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("created Employee payroll data for successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("id") int empId,
                                                                 @Valid @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData =  employeePayrollService.updateEmployeePayrollData( empId,empPayrollDTO);
        ResponseDTO responseDTO =  new ResponseDTO("updated employee payroll data for successful",employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{empid}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empid")int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " +empId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department){
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.findEmployeesByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("Get call for Id successfully", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }



}


