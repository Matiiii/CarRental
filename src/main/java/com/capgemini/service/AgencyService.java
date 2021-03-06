package com.capgemini.service;

import java.util.Set;

import com.capgemini.exceptions.ObjectNotExistException;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.EmployeeTO;

public interface AgencyService {

	AgencyTO saveNewAgency(AgencyTO newAgency);

	AgencyTO findAgencyById(Long agencyId);

	AgencyTO update(AgencyTO newAgency);

	Set<EmployeeTO> findEmployeesByAgencyId(Long agencyId);

	AgencyTO addEmployeeToAgency(Long agencyId, Long employee);

	void delete(Long agencyId);

	AgencyTO deleteEmpoyeeFromAgency(Long agencyId, Long employeeId) throws ObjectNotExistException;

}
