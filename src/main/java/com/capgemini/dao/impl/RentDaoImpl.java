package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.RentDao;
import com.capgemini.domain.RentEntity;
import com.capgemini.exceptions.DifferentVersionsException;

@Repository
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDao {

	public void checkVersion(RentEntity entity) {
		if (entity.getVersion() != getOne(entity.getId()).getVersion()) {
			throw new DifferentVersionsException();
		}
	}

	@Override
	public RentEntity update(RentEntity rentEntity) {
		checkVersion(rentEntity);
		return entityManager.merge(rentEntity);
	}
}
