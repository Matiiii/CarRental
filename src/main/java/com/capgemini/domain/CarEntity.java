package com.capgemini.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
<<<<<<< HEAD
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
=======
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity implements Serializable {

	private static final long serialVersionUID = 366128687212415014L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private int version;

	@Column(nullable = true)
	private Timestamp created;

	@Column(nullable = true)
	private Timestamp updated;

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

	@OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
	private Set<RentEntity> rents = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private AgencyEntity agency;

	@ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
	private Set<EmployeeEntity> caregivers = new HashSet<>();

	// for Hibernate
	public CarEntity() {
	}

	@PrePersist
	protected void onCreate() {
		created = new Timestamp(new Date().getTime());
		version = 1;
	}

<<<<<<< HEAD
	@PostUpdate
=======
	@PreUpdate
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
	protected void onUpdate() {
		updated = new Timestamp(new Date().getTime());
		version += 1;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
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

	public AgencyEntity getActualAgency() {
		return agency;
	}

	public void setActualAgency(AgencyEntity actualAgency) {
		this.agency = actualAgency;
	}

	public Set<EmployeeEntity> getCaregivers() {
		return caregivers;
	}

	public void setCaregivers(Set<EmployeeEntity> caregivers) {
		this.caregivers = caregivers;
	}

	public Timestamp getCreated() {
		return created;
	}

	public Timestamp getUpdated() {
		return updated;
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

	public AgencyEntity getAgency() {
		return agency;
	}

	public void setAgency(AgencyEntity agency) {
		this.agency = agency;
	}

}
