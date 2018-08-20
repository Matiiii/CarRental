package com.capgemini.service;

import java.util.Set;

import com.capgemini.enums.CarType;
import com.capgemini.exceptions.ObjectNotExistException;
import com.capgemini.types.CarTO;

public interface CarService {

	CarTO saveNewCar(CarTO newCar);

	CarTO findCarById(Long id);

	CarTO update(CarTO car);

	Set<CarTO> findCarsByBrand(String brand);

	Set<CarTO> findCarsByType(CarType type);

	void delete(Long carId);

	CarTO addEmployeeToCaregivers(Long carId, Long employeId) throws ObjectNotExistException;

}
