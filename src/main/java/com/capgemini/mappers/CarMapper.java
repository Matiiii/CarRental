package com.capgemini.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.types.CarTO;

@Component
public class CarMapper {

	public CarTO map(CarEntity carEntity) {
		if (carEntity != null) {

			Set<Long> caregiversId = new HashSet<>();
			if (!carEntity.getCaregivers().isEmpty()) {
				carEntity.getCaregivers().stream().forEach(employee -> caregiversId.add(employee.getId()));
			}

			Set<Long> rentsId = new HashSet<>();
			if (!carEntity.getRents().isEmpty()) {
				carEntity.getRents().stream().forEach(rent -> rentsId.add(rent.getId()));
			}

			return CarTO.builder().id(carEntity.getId()).brand(carEntity.getBrand()).color(carEntity.getColor())
					.created(carEntity.getCreated()).updated(carEntity.getUpdated()).version(carEntity.getVersion())
					.engineCapacity(carEntity.getEngineCapacity()).caregivers(caregiversId).rents(rentsId)
					.mileage(carEntity.getMileage()).power(carEntity.getPower()).id(carEntity.getId())
					.carType(carEntity.getCarType()).build();

		}
		return null;
	}

	public CarEntity map(CarTO carTO) {
		if (carTO != null) {

			Set<EmployeeEntity> caregivers = new HashSet<>();
			Set<RentEntity> rents = new HashSet<>();

			CarEntity carEntity = new CarEntity();
			carEntity.setId(carTO.getId());
			carEntity.setBrand(carTO.getBrand());
			carEntity.setColor(carTO.getColor());
			carEntity.setEngineCapacity(carTO.getEngineCapacity());
			carEntity.setMileage(carTO.getMileage());
			carEntity.setPower(carTO.getPower());
			carEntity.setCarType(carTO.getCarType());
			carEntity.setVersion(carTO.getVersion());
			carEntity.setCaregivers(caregivers);
			carEntity.setRents(rents);

			return carEntity;

		}
		return null;
	}

	public Set<CarTO> map2To(Set<CarEntity> carEntiti) {
		if (carEntiti != null) {
			return carEntiti.stream().map(this::map).collect(Collectors.toSet());
		}
		return null;

	}

	public Set<CarEntity> map2Entity(Set<CarTO> carTO) {
		if (carTO != null) {
			return carTO.stream().map(this::map).collect(Collectors.toSet());
		}
		return null;
	}

}
