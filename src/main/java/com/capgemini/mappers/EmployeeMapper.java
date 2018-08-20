package com.capgemini.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.EmployeeTO;

@Component
public class EmployeeMapper {

	public EmployeeTO map(EmployeeEntity employeeEntity) {
		if (employeeEntity != null) {

			Long agencyId = null;
			if (employeeEntity.getAgency() != null) {
				agencyId = employeeEntity.getAgency().getId();
			}

			Set<Long> carsId = new HashSet<>();
			if (!employeeEntity.getCars().isEmpty()) {
				employeeEntity.getCars().stream().forEach(cars -> carsId.add(cars.getId()));
			}

			return EmployeeTO.builder().id(employeeEntity.getId()).position(employeeEntity.getPosition())
					.personalDetail(employeeEntity.getPersonalDetail()).cars(carsId)
					.version(employeeEntity.getVersion()).agency(agencyId).created(employeeEntity.getCreated())
					.updated(employeeEntity.getUpdated()).build();
		}

		return null;
	}

	public EmployeeEntity map(EmployeeTO employeeTO) {
		if (employeeTO != null) {

			EmployeeEntity employeeEntity = new EmployeeEntity();

			employeeEntity.setId(employeeTO.getId());
			employeeEntity.setPersonalDetail(employeeTO.getPersonalDetail());
			employeeEntity.setPosition(employeeTO.getPosition());
			employeeEntity.setVersion(employeeTO.getVersion());

			return employeeEntity;

		}
		return null;
	}

	public Set<EmployeeTO> map2To(Set<EmployeeEntity> employeeEntity) {
		return employeeEntity.stream().map(this::map).collect(Collectors.toSet());

	}

	public Set<EmployeeEntity> map2Entity(Set<EmployeeTO> employeeTO) {
		return employeeTO.stream().map(this::map).collect(Collectors.toSet());
	}

}
