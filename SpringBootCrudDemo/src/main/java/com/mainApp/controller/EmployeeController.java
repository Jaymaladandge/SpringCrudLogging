package com.mainApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainApp.SpringBootCrudApp;
import com.mainApp.model.Employee;
import com.mainApp.model.PFProcess;
import com.mainApp.service.EmployeeService;
import com.mainApp.service.OrganizationService;

@RestController
@RequestMapping("/app")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
//	private static final Logger logger = LoggerFactory.getLogger(SpringBootCrudApp.class);

	@Autowired
	EmployeeService employeeService;

	@Autowired
	OrganizationService service;

	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {
		logger.trace("This is a TRACE message.");
		logger.debug("This is a DEBUG message.");
		logger.info("This is an INFO message.");
		logger.warn("This is a WARN message.");
		logger.error("You guessed it, an ERROR message.");
		return employeeService.getAllEmployees();
	}

	@PostMapping("/emp")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		PFProcess pfProcess = new PFProcess();
		pfProcess.setEmpId(employee.getEmpId());
		pfProcess.setAmount(2000);
		return service.joinOrganization(employee, pfProcess);
	}

	@GetMapping("/emp/{id}")
	public Employee getEmpById(@PathVariable long id) {
		logger.debug("Request {}", id);
		logger.debug("Rsponse {}", "Welcome to logs demo...........!!");
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/emp/{id}")
	public Employee updateEmployee(@PathVariable long id, @Valid @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/emp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
		Employee employee=employeeService.getEmployeeById(id);
		service.leaveOrganization(employee);
		return ResponseEntity.ok().build();
	}

}
