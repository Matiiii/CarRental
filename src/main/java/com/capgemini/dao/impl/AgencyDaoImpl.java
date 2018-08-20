package com.capgemini.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AgencyDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.DifferentVersionsException;

@Repository
public class AgencyDaoImpl extends AbstractDao<AgencyEntity, Long> implements AgencyDao {

	@Override
	public Set<EmployeeEntity> findAllEmployeesByAgencyId(Long agencyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void checkVersion(AgencyEntity entity) {
		if (entity.getVersion() != getOne(entity.getId()).getVersion()) {
			throw new DifferentVersionsException();
		}
	}

	@Override
	public AgencyEntity updateWithRelations(AgencyEntity agency) {
		checkVersion(agency);

		AgencyEntity agencyToUpdate = findOne(agency.getId());

		agency.setEmployees(agencyToUpdate.getEmployees());

		return update(agency);
	}

	@Override
	public AgencyEntity addEmployeeToAgency(Long agencyId, EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
