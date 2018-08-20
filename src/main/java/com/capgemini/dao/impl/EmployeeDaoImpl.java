package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.DifferentVersionsException;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	public void checkVersion(EmployeeEntity entity) {
		if (entity.getVersion() != getOne(entity.getId()).getVersion()) {
			throw new DifferentVersionsException();
		}
	}

	@Override
	public EmployeeEntity updateWithRelations(EmployeeEntity employee) {
		checkVersion(employee);

		EmployeeEntity employeeToUpdate = findOne(employee.getId());

		employee.setCars(employeeToUpdate.getCars());
		employee.setAgency(employeeToUpdate.getAgency());

		return update(employee);
	}

	@Override
	public EmployeeEntity addAgencyToEmployee(Long employeeId, AgencyEntity agencyToAdd) {

		EmployeeEntity employeeToUpdate = getOne(employeeId);
		employeeToUpdate.setAgency(agencyToAdd);

		return update(employeeToUpdate);
	}

}
