package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarSeviceImpl implements CarService {

	@Autowired
	private CarDao carRepository;

	@Autowired
	private CarMapper carmapper;

	@Override
	@Transactional(readOnly = false)
	public CarTO saveNewCar(CarTO newCar) {
		CarEntity carEntity = carmapper.map(newCar);
		CarEntity savedCar = carRepository.save(carEntity);
		return carmapper.map(savedCar);
	}

	@Override
	public CarTO findCarById(Long id) {

		CarEntity car = carRepository.findOne(id);
		return carmapper.map(car);

	}

<<<<<<< HEAD
	@Override
	@Transactional(readOnly = false)
	public CarTO update(CarTO car) {
		CarEntity carMapped = carmapper.map(car);
		CarEntity updatedCar = carRepository.updateWithRelations(carMapped);

		return carmapper.map(updatedCar);
	}

=======
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
}
