package com.capgemini.dao.impl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.DifferentVersionsException;

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

	public void checkVersion(CarEntity entity) {
		if (entity.getVersion() != getOne(entity.getId()).getVersion()) {
			throw new DifferentVersionsException();
		}
	}

	public CarEntity updateWithRelations(CarEntity car) {

		checkVersion(car);

		CarEntity carToUpdate = findOne(car.getId());

		car.setCaregivers(carToUpdate.getCaregivers());
		car.setRents(carToUpdate.getRents());

		return update(car);

	}

	@Override
	public Set<CarEntity> findByCaregiverId(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CarEntity> findCarByBrand(String brand) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<CarEntity> cq = cb.createQuery(CarEntity.class);
		Root<CarEntity> car = cq.from(CarEntity.class);
		ParameterExpression<String> p = cb.parameter(String.class);
		cq.select(car).where(cb.like(car.get("brand"), p));
		TypedQuery<CarEntity> q = entityManager.createQuery(cq);
		q.setParameter(p, brand);

		return q.getResultList().stream().collect(Collectors.toSet());

	}

}
