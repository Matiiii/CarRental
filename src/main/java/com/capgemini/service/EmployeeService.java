package com.capgemini.service;

import java.util.Set;

import com.capgemini.types.EmployeeTO;

public interface EmployeeService {

	EmployeeTO saveNewEmployee(EmployeeTO newEmployee);

	EmployeeTO findEmployeeById(Long id);

	EmployeeTO update(EmployeeTO car);

	Set<EmployeeTO> findCaregiversByCarId(Long carId);

}
