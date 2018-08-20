package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.enums.CarType;
import com.capgemini.exceptions.ObjectNotExistException;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DataCreator dataCreator;

	@Transactional
	@Test
	public void shouldgetAutoById() {

		// given

		CarTO savedCar = dataCreator.saveNewAudiCar();

		// when

		CarTO selectedCar = carService.findCarById(savedCar.getId());

		// then
		assertNotNull(selectedCar);
		assertEquals(savedCar.getId(), selectedCar.getId());
		assertEquals(savedCar.getBrand(), selectedCar.getBrand());

	}

	@Transactional
	@Test
	public void shouldUpdatedAutoById() {

		// given

		CarTO savedCar = dataCreator.saveNewAudiCar();

		savedCar.setCarType(CarType.VAN);
		savedCar.setColor("White");

		// when

		CarTO updatedCar = carService.update(savedCar);

		// then
		assertNotNull(updatedCar);
		assertEquals(savedCar.getId(), updatedCar.getId());
		assertEquals(savedCar.getColor(), updatedCar.getColor());

	}

	@Transactional
	@Test
	public void shouldGet2AutosByBrand() {

		// given

		CarTO savedCar = dataCreator.saveNewAudiCar();
		dataCreator.saveNewAudiCar();

		// when

		Set<CarTO> selectedCars = carService.findCarsByBrand(savedCar.getBrand());

		// then
		assertNotNull(selectedCars);
		assertEquals(2, selectedCars.size());
		assertEquals(savedCar.getBrand(), selectedCars.iterator().next().getBrand());

	}

	@Transactional
	@Test
	public void shouldDeleteAutoById() {

		// given

		CarTO savedCar = dataCreator.saveNewAudiCar();

		// when
		Long id = savedCar.getId();

		carService.delete(savedCar.getId());

		CarTO selectedCar = carService.findCarById(id);

		// then
		assertNull(selectedCar);

	}

	@Transactional
	@Test
	public void shouldGet2AutoByCarType() {

		// given

		CarTO savedCar = dataCreator.saveNewAudiCar();
		dataCreator.saveNewAudiCar();

		// when

		Set<CarTO> selectedCars = carService.findCarsByType(savedCar.getCarType());

		// then
		assertNotNull(selectedCars);
		assertEquals(2, selectedCars.size());
		assertEquals(savedCar.getCarType(), selectedCars.iterator().next().getCarType());

	}

	@Transactional
	@Test
	public void shouldAddCaregiversToCarAndCarToEmployee() {

		// given

		CarTO savedCar = dataCreator.saveNewAudiCar();
		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();

		// when
		try {
			carService.addEmployeeToCaregivers(savedCar.getId(), savedEmployee.getId());
		} catch (ObjectNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CarTO selectedCar = carService.findCarById(savedCar.getId());
		EmployeeTO selectedEmployee = employeeService.findEmployeeById(savedEmployee.getId());

		// then
		assertNotNull(selectedCar);
		assertNotNull(selectedEmployee);

		assertTrue(selectedCar.getCaregivers().stream().anyMatch(employee -> employee == savedEmployee.getId()));
		assertTrue(selectedEmployee.getCars().stream().anyMatch(car -> car == savedCar.getId()));

	}

}
