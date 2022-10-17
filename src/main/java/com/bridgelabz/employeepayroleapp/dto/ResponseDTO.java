package com.bridgelabz.employeepayroleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class ResponseDTO {


    //here im not using getter and setter and not overriding tostring bez of @data
    //not using parameterized constructor bez of @AllArgsConstructor

    // here data is bean object converted to json
    // it follow bean specification

    private String message;
    private Object data;



}
