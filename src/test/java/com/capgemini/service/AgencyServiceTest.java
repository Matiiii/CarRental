package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Address;
import com.capgemini.types.AgencyTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class AgencyServiceTest {

	@Autowired
	private AgencyService agencyService;

	@Test
	public void shouldGetAgencyById() {

		// given

		Set<Long> employeesId = new HashSet<>();
		Address address = new Address("Lazurowa", "Poznań", "60-655", "2b", "Poland");
		AgencyTO newAgency = AgencyTO.builder().address(address).employees(employeesId).build();

		AgencyTO savedAgency = agencyService.saveNewAgency(newAgency);
		// when

		AgencyTO selectedAgency = agencyService.findAgencyById(savedAgency.getId());

		// then
		assertNotNull(savedAgency);
		assertEquals(savedAgency.getId(), selectedAgency.getId());
		assertEquals(newAgency.getAddress(), selectedAgency.getAddress());

	}

	@Test
	public void shouldUpdatedAgencyById() {

		// given

		Set<Long> employeesId = new HashSet<>();
		Address address = new Address("Lazurowa", "Poznań", "60-655", "2b", "Poland");
		AgencyTO newAgency = AgencyTO.builder().address(address).employees(employeesId).build();

		AgencyTO savedAgency = agencyService.saveNewAgency(newAgency);

		Address address2 = new Address("Kiełbasy", "Wrocław", "56-655", "2b", "Poland");
		AgencyTO AgencyToUpdate = AgencyTO.builder().id(savedAgency.getId()).address(address2).employees(employeesId)
				.build();

		// when
		AgencyTO updatedAgency = agencyService.update(AgencyToUpdate);

		// then
		assertNotNull(updatedAgency);
		assertEquals(savedAgency.getId(), updatedAgency.getId());
		assertEquals(AgencyToUpdate.getAddress(), updatedAgency.getAddress());

	}

}
