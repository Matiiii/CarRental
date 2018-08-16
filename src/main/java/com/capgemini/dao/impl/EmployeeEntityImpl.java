package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class EmployeeEntityImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

}
