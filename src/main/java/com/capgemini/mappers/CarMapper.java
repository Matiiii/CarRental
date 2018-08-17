package com.capgemini.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.RentDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.types.CarTO;

@Component
public class CarMapper {

	@Autowired
	private EmployeeDao employeeRepository;

	@Autowired
	private RentDao rentRepository;

	@Autowired
	private AgencyDao agencyRepository;

	public CarTO map(CarEntity carEntity) {
		if (carEntity != null) {

			Set<Long> caregiversId = new HashSet<>();
			if (!(carEntity.getCaregivers() == null)) {
				carEntity.getCaregivers().stream().forEach(employee -> caregiversId.add(employee.getId()));
			}

			Set<Long> rentsId = new HashSet<>();
			if (!(carEntity.getRents() == null)) {
				carEntity.getRents().stream().forEach(rent -> rentsId.add(rent.getId()));
			}

			return CarTO.builder().brand(carEntity.getBrand()).color(carEntity.getColor())
					.created(carEntity.getCreated()).updated(carEntity.getUpdated()).version(carEntity.getVersion())
					.engineCapacity(carEntity.getEngineCapacity()).caregivers(caregiversId).rents(rentsId)
					.mileage(carEntity.getMileage()).power(carEntity.getPower()).id(carEntity.getId())
					.type(carEntity.getType()).build();
		}
		return null;
	}

	public CarEntity map(CarTO carTO) {
		if (carTO != null) {

			Set<EmployeeEntity> caregivers = new HashSet<>();
			if (!carTO.getCaregivers().isEmpty()) {
				carTO.getCaregivers().stream()
						.forEach(employeeId -> caregivers.add(employeeRepository.getOne(employeeId)));
			}

			Set<RentEntity> rents = new HashSet<>();
			if (!carTO.getRents().isEmpty()) {
				carTO.getRents().stream().forEach(rentId -> rents.add(rentRepository.getOne(rentId)));
			}

			return CarEntity.builder().id(carTO.getId()).agency(agencyRepository.findOne(carTO.getAgency()))
					.brand(carTO.getBrand()).color(carTO.getColor()).engineCapacity(carTO.getEngineCapacity())
					.rents(rents).caregivers(caregivers).mileage(carTO.getMileage()).power(carTO.getPower())
					.type(carTO.getType()).build();
		}
		return null;
	}

	public Set<CarTO> map2To(Set<CarEntity> carEntiti) {
		return carEntiti.stream().map(this::map).collect(Collectors.toSet());
	}

	public Set<CarEntity> map2Entity(Set<CarTO> carTO) {
		return carTO.stream().map(this::map).collect(Collectors.toSet());
	}

}
