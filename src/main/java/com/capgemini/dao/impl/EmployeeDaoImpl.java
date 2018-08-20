package com.capgemini.dao.impl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.exceptions.DifferentVersionsException;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	public void checkVersion(EmployeeEntity entity) {
		if (entity.getVersion() != getOne(entity.getId()).getVersion()) {
			throw new DifferentVersionsException();
		}
	}

	@Override
	public EmployeeEntity update(EmployeeEntity employeeEntity) {
		checkVersion(employeeEntity);
		return entityManager.merge(employeeEntity);
	}

	@Override
	public EmployeeEntity updateWithRelations(EmployeeEntity employee) {
		checkVersion(employee);

		EmployeeEntity employeeToUpdate = findOne(employee.getId());

		employee.setCars(employeeToUpdate.getCars());
		employee.setAgency(employeeToUpdate.getAgency());

		return update(employee);
	}

	@Override
	public Set<EmployeeEntity> findCaregiversByCar(Long carId) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select emp from EmployeeEntity emp inner join emp.cars ec where ec.id = :id", EmployeeEntity.class);
		query.setParameter("id", carId);
		return query.getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Set<EmployeeEntity> findAllCarCarersByCarAndAgency(Long agencyId, Long carId) {

		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("select emp from EmployeeEntity emp join emp.cars c "
						+ "where c.id = :carId and emp.agency.id = :agencyId", EmployeeEntity.class);

		query.setParameter("agencyId", agencyId);
		query.setParameter("carId", carId);

		return query.getResultList().stream().collect(Collectors.toSet());

	}

}
