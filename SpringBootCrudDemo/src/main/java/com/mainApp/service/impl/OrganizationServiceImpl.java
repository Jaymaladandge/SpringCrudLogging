package com.mainApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mainApp.model.Employee;
import com.mainApp.model.PFProcess;
import com.mainApp.service.EmployeeService;
import com.mainApp.service.OrganizationService;
import com.mainApp.service.PFProcessService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService empService;

	@Autowired
	PFProcessService pfService;

	@Override
	@Transactional
	public Employee joinOrganization(Employee employee, PFProcess pfProcess) {
		empService.saveEmployee(employee);
		pfService.startPFProcess(pfProcess);
		return employee;
	}

	@Override
	@Transactional
	public void leaveOrganization(Employee employee) {
		pfService.stopPFProcess(employee.getEmpId());
		empService.deleteEmployee(employee.getEmpId());
	}

}
