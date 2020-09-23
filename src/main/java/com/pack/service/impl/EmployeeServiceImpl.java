package com.pack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pack.entity.Employee;
import com.pack.repository.EmployeeRepository;
import com.pack.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public void register(Employee employee) {
		/*
		 * User user=new User(); user.setUserName(userName); user.setPassword(password);
		 * user.setToken(token);
		 */
		repo.saveAndFlush(employee);

	}

	@Override
	public String login(String userName, String password) {
		
				int count=repo.checkLogin(userName, password);
				if (count==1) {
					return "Login Successfull";
				}
				return "No user available for this Username";
				}

}


