package com.capgemini.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity extends MetaData implements Serializable {

	private static final long serialVersionUID = 366128687212415014L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, length = 20)
	private String brand;

	@Column(nullable = false, length = 20)
	private String type;

	@Column(nullable = false, length = 30)
	private String color;

	@Column(nullable = false)
	private int power;

	@Column(nullable = false)
	private int mileage;

	@Column(name = "engine_cap", nullable = false, length = 50)
	private float engineCapacity;

	@OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<RentEntity> rents = new HashSet<>();

	@ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
	private Set<EmployeeEntity> caregivers = new HashSet<>();

	// for Hibernate
	public CarEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public float getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(float engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public Set<EmployeeEntity> getCaregivers() {
		return caregivers;
	}

	public void setCaregivers(Set<EmployeeEntity> caregivers) {
		this.caregivers = caregivers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<RentEntity> getRents() {
		return rents;
	}

	public void setRents(Set<RentEntity> rents) {
		this.rents = rents;
	}

}
