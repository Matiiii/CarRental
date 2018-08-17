package com.capgemini.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "rent")
public class RentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private int version;

	@Column(nullable = true)
	private Timestamp created;

	@Column(nullable = true)
	private Timestamp updated;

	@Column(name = "rental_start", nullable = false)
	private Timestamp rentalStart;

	@Column(name = "rental_stop", nullable = true)
	private Timestamp rentalStop;

	@ManyToOne
	private AgencyEntity rentalAgencyStart;

	@ManyToOne
	private AgencyEntity rentalAgencyStop;

	@ManyToOne
	private CustomerEntity customer;

	@ManyToOne
	private CarEntity car;

	@Column(nullable = false)
	private Long cost;

	// For Hibernate
	public RentEntity() {
	}

	@PrePersist
	protected void onCreate() {
		created = new Timestamp(new Date().getTime());
		version = 1;
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Timestamp(new Date().getTime());
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

	public void setVersion(int version) {
		this.version = version;
	}

	public Timestamp getRentalStart() {
		return rentalStart;
	}

	public void setRentalStart(Timestamp rentalStart) {
		this.rentalStart = rentalStart;
	}

	public Timestamp getRentalStop() {
		return rentalStop;
	}

	public void setRentalStop(Timestamp rentalStop) {
		this.rentalStop = rentalStop;
	}

	public AgencyEntity getRentalAgencyStart() {
		return rentalAgencyStart;
	}

	public void setRentalAgencyStart(AgencyEntity rentalAgencyStart) {
		this.rentalAgencyStart = rentalAgencyStart;
	}

	public AgencyEntity getRentalAgencyStop() {
		return rentalAgencyStop;
	}

	public void setRentalAgencyStop(AgencyEntity rentalAgencyStop) {
		this.rentalAgencyStop = rentalAgencyStop;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

}
