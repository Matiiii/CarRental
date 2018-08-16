package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

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
}
