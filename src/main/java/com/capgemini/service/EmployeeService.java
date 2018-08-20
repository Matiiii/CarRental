package com.capgemini.service;

import com.capgemini.types.EmployeeTO;

public interface EmployeeService {

	EmployeeTO saveNewEmployee(EmployeeTO newEmployee);

	EmployeeTO findEmployeeById(Long id);

	EmployeeTO update(EmployeeTO car);

	EmployeeTO addCarToCare(Long carId);

}
