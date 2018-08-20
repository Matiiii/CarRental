package com.capgemini.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.types.AgencyTO;

@Component
public class AgencyMapper {
	public AgencyTO map(AgencyEntity agencyEntity) {
		if (agencyEntity != null) {

			Set<Long> employeesId = new HashSet<>();
			if (!agencyEntity.getEmployees().isEmpty()) {
				agencyEntity.getEmployees().stream().forEach(employees -> employeesId.add(employees.getId()));
			}

			return AgencyTO.builder().id(agencyEntity.getId()).address(agencyEntity.getAddress()).employees(employeesId)
					.version(agencyEntity.getVersion()).created(agencyEntity.getCreated())
					.updated(agencyEntity.getUpdated()).build();
		}

		return null;
	}

	public AgencyEntity map(AgencyTO agencyTO) {
		if (agencyTO != null) {

			AgencyEntity agencyEntity = new AgencyEntity();
			agencyEntity.setId(agencyTO.getId());
			agencyEntity.setAddress(agencyTO.getAddress());
			agencyEntity.setVersion(agencyTO.getVersion());

			return agencyEntity;

		}
		return null;
	}

	public Set<AgencyTO> map2To(Set<AgencyEntity> agencyEntiti) {
		return agencyEntiti.stream().map(this::map).collect(Collectors.toSet());

	}

	public Set<AgencyEntity> map2Entity(Set<AgencyTO> agencyTO) {
		return agencyTO.stream().map(this::map).collect(Collectors.toSet());
	}

}
