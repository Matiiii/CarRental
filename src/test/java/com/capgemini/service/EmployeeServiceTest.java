package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.PersonalDetail;
import com.capgemini.enums.Position;
import com.capgemini.types.EmployeeTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void shouldGetEmployeeById() {

		// given

		Set<Long> cars = new HashSet<>();
		PersonalDetail personalDetail = new PersonalDetail();
		personalDetail.setName("Krzysztof");
		personalDetail.setSurname("Jarzyna");
		personalDetail.setPesel(90080132454545L);
		personalDetail.setBirthday(new Date(90, 8, 1));
		personalDetail.setEmail("orzeszek@gmail.com");

		EmployeeTO newEmployee = EmployeeTO.builder().position(Position.SALESMAN).personalDetail(personalDetail)
				.cars(cars).build();

		EmployeeTO savedEmployee = employeeService.saveNewEmployee(newEmployee);
		// when

		EmployeeTO selectedEmployee = employeeService.findEmployeeById(savedEmployee.getId());

		// then
		assertNotNull(selectedEmployee);
		assertEquals(savedEmployee.getId(), selectedEmployee.getId());
		assertEquals(savedEmployee.getPersonalDetail(), selectedEmployee.getPersonalDetail());

	}

	@Test
	public void shouldUpdatedEmployeeById() {

		// given

		Set<Long> cars = new HashSet<>();
		PersonalDetail personalDetail = new PersonalDetail();
		personalDetail.setName("Krzysztof");
		personalDetail.setSurname("Jarzyna");
		personalDetail.setPesel(90080132454545L);
		personalDetail.setBirthday(new Date(90, 8, 1));
		personalDetail.setEmail("orzeszek@gmail.com");

		EmployeeTO newEmployee = EmployeeTO.builder().position(Position.SALESMAN).personalDetail(personalDetail)
				.cars(cars).build();

		EmployeeTO savedEmployee = employeeService.saveNewEmployee(newEmployee);

		EmployeeTO employeeToUpdate = EmployeeTO.builder().id(savedEmployee.getId()).version(savedEmployee.getVersion())
				.position(Position.SUPERVISOR).personalDetail(personalDetail).cars(cars).build();

		// when

		EmployeeTO updatedEmployee = employeeService.update(employeeToUpdate);

		// then
		assertNotNull(updatedEmployee);
		assertEquals(savedEmployee.getId(), updatedEmployee.getId());
		assertEquals(employeeToUpdate.getPosition(), updatedEmployee.getPosition());
	}
}
