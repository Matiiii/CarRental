package com.capgemini.types;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CarTO {

	private long id;
	private int version;
	private Timestamp created;
	private Timestamp updated;
	private String brand;
	private String color;
	private String type;
	private int power;
	private int mileage;
	private float engineCapacity;
	private Set<Long> rents = new HashSet<>();
	private Long agency;
	private Set<Long> caregivers = new HashSet<>();

}
