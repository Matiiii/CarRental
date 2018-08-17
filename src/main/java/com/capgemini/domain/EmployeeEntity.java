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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 320654965226134005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private int version;

	@Column(nullable = true)
	private Timestamp created;

	@Column(nullable = true)
	private Timestamp updated;

	@Column(nullable = false, length = 40)
	private String position;

	@Column(nullable = false, length = 40)
	private Long pesel;

	@Column(nullable = true)
	private Date birthday;

	@Column(nullable = false, length = 40)
	private String name;

	@Column(nullable = false, length = 40)
	private String surname;

	@ManyToOne(fetch = FetchType.LAZY)
	private AgencyEntity agency;

	@Column(nullable = true)
	private int phone;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "car_employee", joinColumns = {
			@JoinColumn(name = "employee_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "car_id", nullable = false, updatable = false) })
	private Set<CarEntity> cars = new HashSet<>();

	@PrePersist
	protected void onCreate() {
		created = new Timestamp(new Date().getTime());
		version = 1;
		setBirthday();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Timestamp(new Date().getTime());

	}

	// for Hibernate
	public EmployeeEntity() {
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getPesel() {
		return pesel;
	}

	public void setPesel(Long pesel) {
		this.pesel = pesel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday() {
		birthday = new PeselValidator(getPesel().toString()).getBirthDate();
	}

	public AgencyEntity getAgency() {
		return agency;
	}

	public void setAgency(AgencyEntity agency) {
		this.agency = agency;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
