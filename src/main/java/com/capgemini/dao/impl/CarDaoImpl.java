package com.capgemini.dao.impl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.RentEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public Set<CarEntity> findByType(String type) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("select * from CarEntity car where upper(car.type) like upper(:type)", CarEntity.class);
		query.setParameter("type", type);
		return query.getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Set<EmployeeEntity> findCaregiversByCar(Long carId) {
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("select * from EmployeeEntity emp where car.id = :id", EmployeeEntity.class);
		query.setParameter("id", carId);
		return query.getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Set<CarEntity> findByBrand(String brand) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("select * from CarEntity car where upper(car.brand) like upper(:brand)", CarEntity.class);
		query.setParameter("brand", brand);
		return query.getResultList().stream().collect(Collectors.toSet());
	}

	public CarEntity updateWithRelations(CarEntity car) {

		CarEntity carToUpdate = findOne(car.getId());

		Set<EmployeeEntity> caregivers = carToUpdate.getCaregivers();

		Set<RentEntity> rents = carToUpdate.getRents();

		update(car);

		/*
		 * carToUpdate.setAgency(car.getAgency());
		 * carToUpdate.setBrand(car.getBrand()); carToUpdate.getColor();
		 */

		carToUpdate.setCaregivers(caregivers);

		carToUpdate.setRents(rents);

		return carToUpdate;

	}

}
