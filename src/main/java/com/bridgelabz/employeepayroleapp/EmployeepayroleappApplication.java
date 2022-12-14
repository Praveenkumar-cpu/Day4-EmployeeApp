package com.bridgelabz.employeepayroleapp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



//{
//		"name":"Praveen",
//		"salary":"5000",
//		"gender":"male",
//		"startDate":"17 Oct 2022",
//		"departments":["HR","Sales"],
//		"note":"All in One",
//		"profilePic":"mypic"
//
//		}


@SpringBootApplication
@Slf4j
public class EmployeepayroleappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeepayroleappApplication.class);
		//SpringApplication.run(EmployeepayroleappApplication.class, args);
		log.info("Hi welcome to Employee Application "+ context.getEnvironment().getProperty("environment")+" Environment");


	}

}
