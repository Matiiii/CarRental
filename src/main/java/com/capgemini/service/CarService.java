package com.capgemini.service;

import com.capgemini.types.CarTO;

public interface CarService {

	CarTO saveNewCar(CarTO newCar);

	CarTO findCarById(Long id);
<<<<<<< HEAD

	CarTO update(CarTO car);
=======
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
}
