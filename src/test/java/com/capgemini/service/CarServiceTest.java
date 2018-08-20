package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.enums.CarType;
import com.capgemini.types.CarTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CarServiceTest {

	@Autowired
	private CarService carService;

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

		Set<Long> rents = new HashSet<>();

		Set<Long> caregivers = new HashSet<>();

		CarTO carAudi = CarTO.builder().brand("Audi").color("Zielony").engineCapacity(2.5F).mileage(20034).power(320)
				.rents(rents).caregivers(caregivers).carType(CarType.WAGON).build();

		CarTO savedCar = carService.saveNewCar(carAudi);

		CarTO carAudi2 = CarTO.builder().id(savedCar.getId()).brand("Audi").color("Czerwony").engineCapacity(2.5F)
				.mileage(20034).power(320).rents(rents).caregivers(caregivers).version(savedCar.getVersion())
				.carType(CarType.VAN).build();

		// when

		CarTO updatedCar = carService.update(carAudi2);

		// then
		assertNotNull(updatedCar);
		assertEquals(savedCar.getId(), updatedCar.getId());
		assertEquals(carAudi2.getColor(), updatedCar.getColor());

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
}
