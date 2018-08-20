package com.capgemini.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.domain.Address;
import com.capgemini.domain.PersonalDetail;
import com.capgemini.enums.CarType;
import com.capgemini.enums.Position;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

@Component
public class DataCreator {

	@Autowired
	private AgencyService agencyService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CarService carService;

	public CarTO saveNewAudiCar() {

		Set<Long> rents = new HashSet<>();

		Set<Long> caregivers = new HashSet<>();
		CarTO carAudi = CarTO.builder().brand("Audi").color("Czarny").engineCapacity(2.5F).mileage(20034).power(320)
				.rents(rents).caregivers(caregivers).carType(CarType.WAGON).build();

		return carService.saveNewCar(carAudi);
	}

	public EmployeeTO saveNewEmployeeKrzysztof() {

		Set<Long> cars = new HashSet<>();
		PersonalDetail personalDetail = new PersonalDetail();
		personalDetail.setName("Krzysztof");
		personalDetail.setSurname("Jarzyna");
		personalDetail.setPesel(90080132454545L);
		personalDetail.setBirthday(new Date(90, 8, 1));
		personalDetail.setEmail("orzeszek@gmail.com");

		EmployeeTO newEmployee = EmployeeTO.builder().position(Position.SALESMAN).personalDetail(personalDetail)
				.cars(cars).build();

		return employeeService.saveNewEmployee(newEmployee);

	}

	public AgencyTO saveNewAgencyPoznan() {

		Set<Long> employeesId = new HashSet<>();
		Address address = new Address("Lazurowa", "Poznań", "60-655", "2b", "Poland");
		AgencyTO newAgency = AgencyTO.builder().address(address).employees(employeesId).build();

		return agencyService.saveNewAgency(newAgency);

	}

}
