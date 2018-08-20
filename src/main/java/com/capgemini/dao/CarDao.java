package com.capgemini.dao;

import java.util.Set;

import com.capgemini.domain.CarEntity;
import com.capgemini.enums.CarType;

public interface CarDao extends Dao<CarEntity, Long> {

	Set<CarEntity> findByCaregiverId(Long employeeId);

	CarEntity updateWithRelations(CarEntity car);

	Set<CarEntity> findCarByBrand(String brand);

	Set<CarEntity> findByType(CarType type);

}
