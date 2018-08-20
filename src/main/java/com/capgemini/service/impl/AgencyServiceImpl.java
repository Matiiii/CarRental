package com.capgemini.service.impl;

import java.util.Set;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.Message;
import com.capgemini.exceptions.ObjectNotExistException;
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
		Preconditions.checkNotNull(newAgency, Message.EMPTY_OBJECT);

		AgencyEntity agencyEntity = agencyMapper.map(newAgency);
		AgencyEntity savedAgency = agencyRepository.save(agencyEntity);
		return agencyMapper.map(savedAgency);

	}

	@Override
	@Transactional(readOnly = false)
	public AgencyTO update(AgencyTO agencyToUpdate) {
		Preconditions.checkNotNull(agencyToUpdate, Message.EMPTY_OBJECT);

		AgencyEntity agencyMapped = agencyMapper.map(agencyToUpdate);
		AgencyEntity updatedAgency = agencyRepository.updateWithRelations(agencyMapped);

		return agencyMapper.map(updatedAgency);
	}

	@Override
	public AgencyTO findAgencyById(Long agencyId) {
		Preconditions.checkNotNull(agencyId, Message.EMPTY_ID);

		return agencyMapper.map(agencyRepository.findOne(agencyId));
	}

	@Override
	public Set<EmployeeTO> findEmployeesByAgencyId(Long agencyId) {
		Preconditions.checkNotNull(agencyId, Message.EMPTY_ID);

		AgencyEntity agency = agencyRepository.getOne(agencyId);

		return employeeMapper.map2To(agency.getEmployees());
	}

	@Override
	@Transactional(readOnly = false)
	public AgencyTO addEmployeeToAgency(Long agencyId, Long employeeId) {
		Preconditions.checkNotNull(agencyId, Message.EMPTY_ID);
		Preconditions.checkNotNull(employeeId, Message.EMPTY_ID);

		AgencyEntity agencyToUpdate = agencyRepository.getOne(agencyId);
		EmployeeEntity employeeToUpdate = employeeRepository.getOne(employeeId);

		agencyToUpdate.getEmployees().add(employeeToUpdate);
		employeeToUpdate.setAgency(agencyToUpdate);

		AgencyEntity updatedAgency = agencyRepository.update(agencyToUpdate);
		employeeRepository.update(employeeToUpdate);

		return agencyMapper.map(updatedAgency);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long agencyId) {
		Preconditions.checkNotNull(agencyId, Message.EMPTY_ID);

		agencyRepository.delete(agencyId);

	}

	@Override
	@Transactional(readOnly = false)
	public AgencyTO deleteEmpoyeeFromAgency(Long agencyId, Long employeeId) throws ObjectNotExistException {
		Preconditions.checkNotNull(agencyId, Message.EMPTY_ID);
		Preconditions.checkNotNull(employeeId, Message.EMPTY_ID);

		EmployeeEntity employee = employeeRepository.getOne(employeeId);
		if (employee == null) {
			throw new ObjectNotExistException("employee " + employeeId);
		}
		AgencyEntity agency = agencyRepository.getOne(agencyId);
		if (agency == null) {
			throw new ObjectNotExistException("agency " + agencyId);
		}

		agency.getEmployees().removeIf(empl -> empl.getId().equals(employeeId));
		employee.setAgency(null);

		AgencyEntity updatedAgency = agencyRepository.update(agency);
		employeeRepository.update(employee);

		return agencyMapper.map(updatedAgency);
	}

}
