package com.capgemini.service;

import com.capgemini.types.CarTO;

public interface CarService {

	CarTO saveNewCar(CarTO newCar);

	CarTO findCarById(Long id);

	CarTO update(CarTO car);
}
