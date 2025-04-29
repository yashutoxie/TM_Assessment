package com.spring.EmployeeManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {
	@Autowired
	EmpRepo empRepo;

	@PostMapping("/addemp")
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {

		return empRepo.save(emp);

	}

	@GetMapping("/emp/{id}")
	@ResponseBody
	public Optional<Employee> findByName(@PathVariable Long id) {
		return empRepo.findById(id);
	}

	@PostMapping("/emp/copy/{newId}")
	@ResponseBody
	public Employee copyWithNewId(@RequestBody Employee emp, @PathVariable Long newId) {
		if (!empRepo.existsById(newId)) {
			emp.setId(newId); // set new ID
			return empRepo.save(emp); // saves as a new record
		} else {
			throw new RuntimeException("ID already exists.");
		}
	}

	@GetMapping("/countemp")
	@ResponseBody
	public Long CountEmp() {
		return empRepo.countAllEmployees();
	}

	@GetMapping("/findByDept/{department}")
	@ResponseBody
	public List<Employee> findByDept(@PathVariable String department) {
		return empRepo.findByDepartment(department);
	}

}
