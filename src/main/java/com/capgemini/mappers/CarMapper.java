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
<<<<<<< HEAD
			if (!(carEntity.getCaregivers() == null)) {
=======
			if (!carEntity.getCaregivers().isEmpty()) {
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
				carEntity.getCaregivers().stream().forEach(employee -> caregiversId.add(employee.getId()));
			}

			Set<Long> rentsId = new HashSet<>();
<<<<<<< HEAD
			if (!(carEntity.getRents() == null)) {
				carEntity.getRents().stream().forEach(rent -> rentsId.add(rent.getId()));
			}

			return CarTO.builder().brand(carEntity.getBrand()).color(carEntity.getColor())
					.created(carEntity.getCreated()).updated(carEntity.getUpdated()).version(carEntity.getVersion())
					.engineCapacity(carEntity.getEngineCapacity()).caregivers(caregiversId).rents(rentsId)
					.mileage(carEntity.getMileage()).power(carEntity.getPower()).id(carEntity.getId())
					.type(carEntity.getType()).build();
=======
			if (!carEntity.getRents().isEmpty()) {
				carEntity.getRents().stream().forEach(rent -> rentsId.add(rent.getId()));
			}

			return new CarTO().builder().agency(carEntity.getAgency().getId()).brand(carEntity.getBrand())
					.color(carEntity.getColor()).created(carEntity.getCreated()).updated(carEntity.getUpdated())
					.version(carEntity.getVersion()).engineCapacity(carEntity.getEngineCapacity())
					.caregivers(caregiversId).rents(rentsId).mileage(carEntity.getMileage()).power(carEntity.getPower())
					.id(carEntity.getId()).type(carEntity.getType()).build();
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
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

<<<<<<< HEAD
			return CarEntity.builder().id(carTO.getId()).agency(agencyRepository.findOne(carTO.getAgency()))
					.brand(carTO.getBrand()).color(carTO.getColor()).engineCapacity(carTO.getEngineCapacity())
					.rents(rents).caregivers(caregivers).mileage(carTO.getMileage()).power(carTO.getPower())
					.type(carTO.getType()).build();
=======
			return new CarEntity().builder().agency(agencyRepository.findOne(carTO.getAgency())).brand(carTO.getBrand())
					.color(carTO.getColor()).engineCapacity(carTO.getEngineCapacity()).caregivers(caregivers)
					.rents(rents).mileage(carTO.getMileage()).power(carTO.getPower()).type(carTO.getType()).build();
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
		}
		return null;
	}

<<<<<<< HEAD
	public Set<CarTO> map2To(Set<CarEntity> carEntiti) {
		return carEntiti.stream().map(this::map).collect(Collectors.toSet());
=======
	public Set<CarTO> map2To(Set<CarEntity> challangeEntiti) {
		return challangeEntiti.stream().map(this::map).collect(Collectors.toSet());
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
	}

	public Set<CarEntity> map2Entity(Set<CarTO> carTO) {
		return carTO.stream().map(this::map).collect(Collectors.toSet());
	}

}
