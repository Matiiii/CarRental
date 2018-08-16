package com.capgemini.dao;

import java.util.Set;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	Set<CarEntity> findByBrand(String brand);

	Set<CarEntity> findByType(String type);

	Set<EmployeeEntity> findCaregiversByCar(Long carId);

}
