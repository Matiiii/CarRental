package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonalDetail {

	@Column(nullable = true)
	private Date birthday;

	@Column(nullable = false, length = 40)
	private String name;

	@Column(nullable = false, length = 40)
	private String surname;

	@Column(nullable = true)
	private int phone;

	@Column(nullable = true, length = 40)
	private Long pesel;
}
