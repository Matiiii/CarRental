package com.capgemini.service.impl;

import java.util.Set;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.enums.CarType;
import com.capgemini.exceptions.Message;
import com.capgemini.exceptions.ObjectNotExistException;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarSeviceImpl implements CarService {

	@Autowired
	private CarDao carRepository;

	@Autowired
	private CarMapper carmapper;

	@Autowired
	EmployeeDao employeeRepository;

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	@Transactional(readOnly = false)
	public CarTO saveNewCar(CarTO newCar) {
		Preconditions.checkNotNull(newCar, Message.EMPTY_OBJECT);

		CarEntity carEntity = carmapper.map(newCar);
		CarEntity savedCar = carRepository.save(carEntity);
		return carmapper.map(savedCar);
	}

	@Override
	public CarTO findCarById(Long id) {
		Preconditions.checkNotNull(id, Message.EMPTY_ID);

		CarEntity car = carRepository.findOne(id);
		return carmapper.map(car);

	}

	@Override
	@Transactional(readOnly = false)
	public CarTO update(CarTO car) {
		Preconditions.checkNotNull(car, Message.EMPTY_OBJECT);

		CarEntity carMapped = carmapper.map(car);
		CarEntity updatedCar = carRepository.updateWithRelations(carMapped);

		return carmapper.map(updatedCar);
	}

	@Override
	public Set<CarTO> findCarsByBrand(String brand) {
		Preconditions.checkNotNull(brand, Message.EMPTY_OBJECT);

		Set<CarEntity> carList = carRepository.findCarByBrand(brand);
		return carmapper.map2To(carList);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long carId) {
		Preconditions.checkNotNull(carId, Message.EMPTY_OBJECT);

		carRepository.delete(carId);

	}

	@Override
	public Set<CarTO> findCarsByType(CarType type) {
		Preconditions.checkNotNull(type, Message.EMPTY_OBJECT);

		Set<CarEntity> cars = carRepository.findByType(type);

		return carmapper.map2To(cars);
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO addEmployeeToCaregivers(Long carId, Long employeId) throws ObjectNotExistException {
		Preconditions.checkNotNull(carId, Message.EMPTY_ID);
		Preconditions.checkNotNull(employeId, Message.EMPTY_ID);

		CarEntity carToupdate = carRepository.getOne(carId);
		if (carToupdate == null) {
			throw new ObjectNotExistException("car " + carId);
		}
		EmployeeEntity employeeToUpdate = employeeRepository.getOne(employeId);
		if (employeeToUpdate == null) {
			throw new ObjectNotExistException("agency " + employeId);
		}

		carToupdate.getCaregivers().add(employeeToUpdate);
		employeeToUpdate.getCars().add(carToupdate);

		CarEntity updatedCar = carRepository.update(carToupdate);
		employeeRepository.update(employeeToUpdate);

		return carmapper.map(updatedCar);
	}

}
