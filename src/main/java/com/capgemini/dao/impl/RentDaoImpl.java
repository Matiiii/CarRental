package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.RentDao;
import com.capgemini.domain.RentEntity;

@Repository
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDao {

}
