package com.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.DemoJpa.Employee;
 

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long>{
	 @Query("SELECT e FROM Employee e")
	 List<Employee> getAllEmps();
}
