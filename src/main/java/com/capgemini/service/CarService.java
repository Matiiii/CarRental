package com.capgemini.service;

import java.util.Set;

import com.capgemini.types.CarTO;

public interface CarService {

	CarTO saveNewCar(CarTO newCar);

	CarTO findCarById(Long id);

	CarTO update(CarTO car);

	CarTO addCaregive(Long employeeId);

	Set<CarTO> findCarsByBrand(String brand);

	void delete(Long carId);

}
