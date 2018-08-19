package com.capgemini.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCY")
public class AgencyEntity extends MetaData implements Serializable {

	private static final long serialVersionUID = 7503221853516892066L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	private Set<EmployeeEntity> employees = new HashSet<>();

	public AgencyEntity() {
	}

	public AgencyEntity(Long id, String name, Address address, Set<EmployeeEntity> employees) {
		this.id = id;

		this.address = address;
		this.employees = employees;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}

}
