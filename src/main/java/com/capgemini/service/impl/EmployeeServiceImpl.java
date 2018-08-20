package com.capgemini.service.impl;

import java.util.Set;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.Message;
import com.capgemini.exceptions.ObjectNotExistException;
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
		Preconditions.checkNotNull(newEmployee, Message.EMPTY_OBJECT);

		EmployeeEntity employeeEntity = employeeMapper.map(newEmployee);
		EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
		return employeeMapper.map(savedEmployee);
	}

	@Override
	public EmployeeTO findEmployeeById(Long id) {
		Preconditions.checkNotNull(id, Message.EMPTY_ID);

		EmployeeEntity car = employeeRepository.findOne(id);
		return employeeMapper.map(car);
	}

	@Override
	@Transactional(readOnly = false)
	public EmployeeTO update(EmployeeTO employee) {
		Preconditions.checkNotNull(employee, Message.EMPTY_OBJECT);

		EmployeeEntity employeeMapped = employeeMapper.map(employee);
		EmployeeEntity updatedEmployee = employeeRepository.updateWithRelations(employeeMapped);

		return employeeMapper.map(updatedEmployee);

	}

	@Override
	public Set<EmployeeTO> findCaregiversByCarId(Long carId) {
		Preconditions.checkNotNull(carId, Message.EMPTY_ID);

		Set<EmployeeEntity> caregivers = employeeRepository.findCaregiversByCar(carId);

		return employeeMapper.map2To(caregivers);
	}

	@Override
	public Set<EmployeeTO> findAllCaregiversByAgencyIdAndCarId(Long agencyId, Long carId)
			throws ObjectNotExistException {
		Preconditions.checkNotNull(agencyId, Message.EMPTY_ID);
		Preconditions.checkNotNull(carId, Message.EMPTY_ID);

		Set<EmployeeEntity> selectedEmployees = employeeRepository.findAllCarCarersByCarAndAgency(agencyId, carId);
		if (selectedEmployees == null) {
			throw new ObjectNotExistException("employee: " + "agencyId " + agencyId + "carId " + carId);
		}

		return employeeMapper.map2To(selectedEmployees);
	}

}
