package com.capgemini.dao;

import java.util.Set;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;

public interface AgencyDao extends Dao<AgencyEntity, Long> {

	Set<EmployeeEntity> findAllEmployeesByAgencyId(Long agencyId);

	AgencyEntity updateWithRelations(AgencyEntity agencyToUpdate);

	AgencyEntity addEmployeeToAgency(Long agencyId, EmployeeEntity employee);

}
