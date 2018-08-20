package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.enums.Position;
import com.capgemini.exceptions.DifferentVersionsException;
import com.capgemini.exceptions.ObjectNotExistException;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CarService carService;

	@Autowired
	private AgencyService agencyService;

	@Autowired
	private DataCreator dataCreator;

	@Transactional
	@Test
	public void shouldGetEmployeeById() {

		// given

		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();
		// when

		EmployeeTO selectedEmployee = employeeService.findEmployeeById(savedEmployee.getId());

		// then
		assertNotNull(selectedEmployee);
		assertEquals(savedEmployee.getId(), selectedEmployee.getId());
		assertEquals(savedEmployee.getPersonalDetail(), selectedEmployee.getPersonalDetail());

	}

	@Transactional
	@Test
	public void shouldUpdatedEmployeeById() {

		// given

		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();

		savedEmployee.setPosition(Position.SUPERVISOR);
		// when

		EmployeeTO updatedEmployee = employeeService.update(savedEmployee);

		// then
		assertNotNull(updatedEmployee);
		assertEquals(savedEmployee.getId(), updatedEmployee.getId());
		assertEquals(savedEmployee.getPosition(), updatedEmployee.getPosition());
	}

	@Transactional
	@Test(expected = DifferentVersionsException.class)
	public void shouldNotUpdatedEmployeeById() {

		// given

		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();

		savedEmployee.setPosition(Position.SUPERVISOR);
		employeeService.update(savedEmployee);

		savedEmployee.setPosition(Position.ACCOUNTANT);
		savedEmployee.setVersion(20);
		// when

		employeeService.update(savedEmployee);

		// then
	}

	@Transactional
	@Test
	public void shouldGet2CaregiversByCarId() {

		// given

		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee2 = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee3 = dataCreator.saveNewEmployeeKrzysztof();

		CarTO savedCar = dataCreator.saveNewAudiCar();
		CarTO savedCar2 = dataCreator.saveNewAudiCar();

		try {
			carService.addEmployeeToCaregivers(savedCar.getId(), savedEmployee.getId());
			carService.addEmployeeToCaregivers(savedCar.getId(), savedEmployee2.getId());
			carService.addEmployeeToCaregivers(savedCar2.getId(), savedEmployee3.getId());
		} catch (ObjectNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// when

		Set<EmployeeTO> selectedEmployees = employeeService.findCaregiversByCarId(savedCar.getId());

		// then
		assertNotNull(selectedEmployees);
		assertEquals(2, selectedEmployees.size());
		assertTrue(selectedEmployees.stream().anyMatch(employee -> employee.getId() == savedEmployee.getId()));
		assertFalse(selectedEmployees.stream().anyMatch(employee -> employee.getId() == savedEmployee3.getId()));
		assertTrue(selectedEmployees.stream().anyMatch(employee -> employee.getId() == savedEmployee2.getId()));

	}

	@Transactional
	@Test
	public void shouldGet1CaregiverByAgencyIdAndCarId() {

		// given

		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee2 = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee3 = dataCreator.saveNewEmployeeKrzysztof();

		CarTO savedCar = dataCreator.saveNewAudiCar();
		CarTO savedCar2 = dataCreator.saveNewAudiCar();

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();
		AgencyTO savedAgency2 = dataCreator.saveNewAgencyPoznan();

		try {
			carService.addEmployeeToCaregivers(savedCar.getId(), savedEmployee.getId());
			carService.addEmployeeToCaregivers(savedCar.getId(), savedEmployee2.getId());
			carService.addEmployeeToCaregivers(savedCar2.getId(), savedEmployee3.getId());
		} catch (ObjectNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee.getId());
		agencyService.addEmployeeToAgency(savedAgency2.getId(), savedEmployee2.getId());
		agencyService.addEmployeeToAgency(savedAgency2.getId(), savedEmployee3.getId());

		// when

		Set<EmployeeTO> selectedEmployees = null;
		try {
			selectedEmployees = employeeService.findAllCaregiversByAgencyIdAndCarId(savedAgency.getId(),
					savedCar.getId());
		} catch (ObjectNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// then
		assertNotNull(selectedEmployees);
		assertEquals(1, selectedEmployees.size());
		assertTrue(selectedEmployees.stream().anyMatch(employee -> employee.getId() == savedEmployee.getId()));
		assertFalse(selectedEmployees.stream().anyMatch(employee -> employee.getId() == savedEmployee3.getId()));
		assertFalse(selectedEmployees.stream().anyMatch(employee -> employee.getId() == savedEmployee2.getId()));

	}

}
