package com.spring.EmployeeManagement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

	Employee findByName(String name);

	@Query("SELECT e FROM Employee e WHERE e.name = ?")
	Employee findbyName(String name);

	@Query("SELECT e FROM Employee e WHERE e.department =: dept")
	List<Employee> findByDepartment(@org.springframework.data.repository.query.Param("dept") String department);

	@Query("SELECT COUNT(e) FROM Employee e")
	Long countAllEmployees();

}
