package com.capgemini.service;

import com.capgemini.types.AgencyTO;

public interface AgencyService {

	AgencyTO saveNewAgency(AgencyTO newAgency);

	AgencyTO findAgencyById(Long agencyId);

	AgencyTO update(AgencyTO newAgency);

}
