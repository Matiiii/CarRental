package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.AgencyDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.mappers.AgencyMapper;
import com.capgemini.service.AgencyService;
import com.capgemini.types.AgencyTO;

@Service
@Transactional(readOnly = true)
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	AgencyDao agencyRepository;

	@Autowired
	AgencyMapper agencyMapper;

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

}
