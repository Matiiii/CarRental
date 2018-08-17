package com.capgemini.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AgencyDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class AgencyDaoImpl extends AbstractDao<AgencyEntity, Long> implements AgencyDao {

	@Override
	public Set<EmployeeEntity> findAllEmployeesByAgency(Long agencyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
