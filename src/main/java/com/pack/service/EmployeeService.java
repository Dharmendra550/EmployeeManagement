package com.pack.service;

import org.springframework.stereotype.Service;

import com.pack.entity.Employee;
@Service
public interface EmployeeService
{
	public void register(Employee employee);
    public String login(String userName,String password);
}
