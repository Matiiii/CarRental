package com.capgemini.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.AgencyMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.AgencyService;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.EmployeeTO;

@Service
@Transactional(readOnly = true)
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	AgencyDao agencyRepository;

	@Autowired
	EmployeeDao employeeRepository;

	@Autowired
	AgencyMapper agencyMapper;

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	@Transactional(readOnly = false)
	public AgencyTO saveNewAgency(AgencyTO newAgency) {

		AgencyEntity agencyEntity = agencyMapper.map(newAgency);
		AgencyEntity savedAgency = agencyRepository.save(agencyEntity);
		return agencyMapper.map(savedAgency);

	}

	@Override
	@Transactional(readOnly = false)
	public AgencyTO update(AgencyTO agencyToUpdate) {
		AgencyEntity agencyMapped = agencyMapper.map(agencyToUpdate);
		AgencyEntity updatedAgency = agencyRepository.updateWithRelations(agencyMapped);

		return agencyMapper.map(updatedAgency);
	}

	@Override
	public AgencyTO findAgencyById(Long agencyId) {

		return agencyMapper.map(agencyRepository.findOne(agencyId));
	}

	@Override
	public Set<EmployeeTO> findEmployeesByAgencyId(Long agencyId) {

		AgencyEntity agency = agencyRepository.getOne(agencyId);

		return employeeMapper.map2To(agency.getEmployees());
	}

	@Override
	@Transactional(readOnly = false)
	public AgencyTO addEmployeeToAgency(Long agencyId, Long employeeId) {

		AgencyEntity agencyToUpdate = agencyRepository.getOne(agencyId);
		EmployeeEntity employeeToUpdate = employeeRepository.getOne(employeeId);

		agencyToUpdate.getEmployees().add(employeeToUpdate);
		employeeToUpdate.setAgency(agencyToUpdate);

		AgencyEntity updatedAgency = agencyRepository.update(agencyToUpdate);
		employeeRepository.update(employeeToUpdate);

		return agencyMapper.map(updatedAgency);
	}

}
