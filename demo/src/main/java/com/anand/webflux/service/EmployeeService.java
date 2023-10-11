package com.anand.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anand.webflux.dao.EmployeeRepo;
import com.anand.webflux.model.EmployeeDTO;

@Component
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public void saveEmployee(EmployeeDTO emp) {
		employeeRepo.save(emp);
	}


}
