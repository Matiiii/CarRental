package com.capgemini.dao;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	EmployeeEntity updateWithRelations(EmployeeEntity employee);

	EmployeeEntity addAgencyToEmployee(Long employeeId, AgencyEntity agencyToAdd);

}
