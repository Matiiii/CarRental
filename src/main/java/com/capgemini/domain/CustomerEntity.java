package com.capgemini.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends MetaData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2964879080822792391L;

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
	private String street;

	@Column(nullable = false, length = 40)
	private String city;

	@Column(name = "postal_code", nullable = false, length = 10)
	private String postalCode;

	@Column(name = "hause_number", nullable = false, length = 15)
	private String hauseNumber;

	@Column(nullable = false, length = 20)
	private String country;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false, length = 20)
	private String surname;

	@Column(nullable = false)
	private Date birthday;

	@Column(name = "credit_card", nullable = false)
	private Long creditCard;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = true)
	private int phone;

	// For Hibernate
	public CustomerEntity() {
	}

	@PrePersist
	@Override
	protected void onCreate() {
		created = new Timestamp(new Date().getTime());
		version = 1;
	}

	@PreUpdate
	@Override
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getHauseNumber() {
		return hauseNumber;
	}

	public void setHauseNumber(String hauseNumber) {
		this.hauseNumber = hauseNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
