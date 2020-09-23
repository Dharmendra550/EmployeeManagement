package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pack.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> 
{
	@Query(value="select count(*) from emp  where  user_name=?  and  password=?",nativeQuery = true)
	public int checkLogin(String userName, String password);
}
