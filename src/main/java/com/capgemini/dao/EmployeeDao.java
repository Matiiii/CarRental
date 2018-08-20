package com.capgemini.dao;

import java.util.Set;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	EmployeeEntity updateWithRelations(EmployeeEntity employee);

	Set<EmployeeEntity> findCaregiversByCar(Long carId);

}
