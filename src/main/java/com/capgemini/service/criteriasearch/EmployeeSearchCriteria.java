package com.capgemini.service.criteriasearch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.capgemini.domain.EmployeeEntity;

public class EmployeeSearchCriteria {

	@PersistenceContext
	protected EntityManager entityManager;

	// some parameters to your method
	String agency;
	String cars;
	String position;

	CriteriaBuilder qb = entityManager.getCriteriaBuilder();
	CriteriaQuery cq = qb.createQuery();
	Root<EmployeeEntity> employee = cq.from(EmployeeEntity.class);

	// Constructing list of parameters
	List<Predicate> predicates = new ArrayList<>();

	{

		// Adding predicates in case of parameter not being null
		if (agency != null) {
			predicates.add(qb.equal(employee.get("agency"), agency));
		}
		if (cars != null) {
			predicates.add(qb.equal(employee.get("cars"), cars));
		}
		if (position != null) {
			predicates.add(qb.equal(employee.get("position"), position));
		}
		// query itself
		cq.select(employee).where(predicates.toArray(new Predicate[] {}));
		// execute query and do something with result

		entityManager.createQuery(cq).getResultList();

	}
}
