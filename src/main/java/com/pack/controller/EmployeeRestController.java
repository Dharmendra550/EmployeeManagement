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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Employee;
import com.pack.repository.EmployeeRepository;
import com.pack.service.EmployeeService;

@RestController
public class EmployeeRestController 
{

		@Autowired
		EmployeeService service;

		@PostMapping("/signup")
		public ResponseEntity<String> doregister(@RequestBody Employee employee) {
			service.register(employee);
			return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);

		}

		@PostMapping("/signin")
		@ResponseStatus(value=HttpStatus.FOUND)
		public String login(@RequestParam String userName, @RequestParam String password) {

			return service.login(userName, password);
		}

	}
