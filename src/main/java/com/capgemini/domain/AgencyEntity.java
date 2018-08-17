package com.capgemini.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AGENCY")
public class AgencyEntity implements Serializable {

	private static final long serialVersionUID = 7503221853516892066L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true, length = 40)
	private String name;

	@Embedded
	private MetaData metadata;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	Set<EmployeeEntity> employees = new HashSet<>();

	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	Set<CarEntity> carsInAgency = new HashSet<>();

}
