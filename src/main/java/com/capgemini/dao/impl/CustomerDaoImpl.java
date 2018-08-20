package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.domain.CustomerEntity;
import com.capgemini.exceptions.DifferentVersionsException;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> {

	public void checkVersion(CustomerEntity entity) {
		if (entity.getVersion() != getOne(entity.getId()).getVersion()) {
			throw new DifferentVersionsException();
		}
	}

	@Override
	public CustomerEntity update(CustomerEntity customerEntity) {
		checkVersion(customerEntity);
		return entityManager.merge(customerEntity);
	}

}
