package com.capgemini.types;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.enums.CarType;

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
	private Date created;
	private Date updated;
	private String brand;
	private String color;
	private CarType carType;
	private int power;
	private int mileage;
	private float engineCapacity;
	private Set<Long> rents = new HashSet<>();
	private Set<Long> caregivers = new HashSet<>();

}
