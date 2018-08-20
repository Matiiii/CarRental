package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.types.EmployeeTO;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService

{

	@Autowired
	private EmployeeDao employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	@Transactional(readOnly = false)
	public EmployeeTO saveNewEmployee(EmployeeTO newEmployee) {
		EmployeeEntity employeeEntity = employeeMapper.map(newEmployee);
		EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
		return employeeMapper.map(savedEmployee);
	}

	@Override
	public EmployeeTO findEmployeeById(Long id) {

		EmployeeEntity car = employeeRepository.findOne(id);
		return employeeMapper.map(car);
	}

	@Override
	@Transactional(readOnly = false)
	public EmployeeTO update(EmployeeTO employee) {
		{
			EmployeeEntity employeeMapped = employeeMapper.map(employee);
			EmployeeEntity updatedEmployee = employeeRepository.updateWithRelations(employeeMapped);

			return employeeMapper.map(updatedEmployee);
		}
	}

	@Override
	public EmployeeTO addCarToCare(Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
