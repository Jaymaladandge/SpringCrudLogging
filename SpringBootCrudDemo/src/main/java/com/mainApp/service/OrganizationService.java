package com.mainApp.service;

import com.mainApp.model.Employee;
import com.mainApp.model.PFProcess;

public interface OrganizationService {

	public Employee joinOrganization(Employee employee, PFProcess pfProcess);
	public void leaveOrganization(Employee employee);
}
