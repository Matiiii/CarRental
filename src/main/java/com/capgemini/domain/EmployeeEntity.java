package com.capgemini.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends MetaData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 320654965226134005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Position position;

	@ManyToOne(fetch = FetchType.LAZY)
	private AgencyEntity agency;

	@Embedded
	private PersonalDetail personalDetail;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "car_employee", joinColumns = {
			@JoinColumn(name = "employee_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "car_id", nullable = false, updatable = false) })
	private Set<CarEntity> cars = new HashSet<>();

	// for Hibernate
	public EmployeeEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AgencyEntity getAgency() {
		return agency;
	}

	public void setAgency(AgencyEntity agency) {
		this.agency = agency;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}

	public Set<CarEntity> getCars() {
		return cars;
	}

	public void setCars(Set<CarEntity> cars) {
		this.cars = cars;
	}

}
