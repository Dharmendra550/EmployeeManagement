package com.pack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Employee;
import com.pack.repository.EmployeeRepository;

@RestController
public class EmployeeRestController 
{
@Autowired
EmployeeRepository repo;

@GetMapping("/all")
public ResponseEntity<List<Employee>> getAlldata()
{
	List<Employee> empList=repo.findAll();
	return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
}
@GetMapping("/all/{empid}")
public ResponseEntity<Optional<Employee>> getEmpById(@PathVariable("empid") Integer empId)
{
	Optional<Employee> opt=repo.findById(empId);
	return new ResponseEntity<Optional<Employee>>(opt,HttpStatus.OK);
	
}
@PostMapping("/all/create")
public String storeEmployee(@RequestBody Employee employee)
{
	boolean flag=repo.existsById(employee.getToken());
	if(flag==true)
	{
		return "Token alraedy exist";
		
	}
	else
	{
		repo.save(employee);
		return "Token added to database";
	}
}

}
