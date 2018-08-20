package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import com.capgemini.domain.Address;
import com.capgemini.exceptions.ObjectNotExistException;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.EmployeeTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class AgencyServiceTest {

	@Autowired
	private AgencyService agencyService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DataCreator dataCreator;

	@Transactional
	@Test
	public void shouldGetAgencyById() {

		// given

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();
		// when

		AgencyTO selectedAgency = agencyService.findAgencyById(savedAgency.getId());

		// then
		assertNotNull(savedAgency);
		assertEquals(savedAgency.getId(), selectedAgency.getId());
		assertEquals(savedAgency.getAddress(), selectedAgency.getAddress());

	}

	@Transactional
	@Test
	public void shouldUpdatedAgencyById() {

		// given

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();

		Address newAddress = new Address("Kiełbasy", "Wrocław", "56-655", "2b", "Poland");
		savedAgency.setAddress(newAddress);

		// when
		AgencyTO updatedAgency = agencyService.update(savedAgency);

		// then
		assertNotNull(updatedAgency);
		assertEquals(savedAgency.getId(), updatedAgency.getId());
		assertEquals(savedAgency.getAddress(), updatedAgency.getAddress());

	}

	@Transactional
	@Test
	public void shouldAddEmployeeToAgency() {

		// given

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();
		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee2 = dataCreator.saveNewEmployeeKrzysztof();

		// when

		AgencyTO agencyAfterOperation = agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee.getId());
		EmployeeTO employeeAfterOp = employeeService.findEmployeeById(savedEmployee.getId());

		agencyAfterOperation = agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee2.getId());
		// then
		assertNotNull(agencyAfterOperation);
		assertEquals(savedAgency.getId(), agencyAfterOperation.getId());
		assertTrue(agencyAfterOperation.getEmployees().contains(savedEmployee.getId()));
		assertEquals(savedAgency.getId(), employeeAfterOp.getAgency());
	}

	@Transactional
	@Test
	public void shoulsReturn2EmployeesFromAgency() {

		// given

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();
		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee2 = dataCreator.saveNewEmployeeKrzysztof();

		agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee.getId());
		agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee2.getId());
		// when

		Set<EmployeeTO> employees = agencyService.findEmployeesByAgencyId(savedAgency.getId());

		// then

		assertNotNull(employees);
		assertEquals(2, employees.size());
		assertTrue(employees.stream().anyMatch(employee -> employee.getId() == savedEmployee.getId()));
		assertTrue(employees.stream().anyMatch(employee -> employee.getId() == savedEmployee2.getId()));

	}

	@Transactional
	@Test
	public void shouldDeletedAgencyById() {

		// given

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();
		// when

		Long id = savedAgency.getId();
		agencyService.delete(id);

		AgencyTO selectedAgency = agencyService.findAgencyById(savedAgency.getId());

		// then
		assertNull(selectedAgency);

	}

	@Transactional
	@Test
	public void shoulsDeleteEmployeeFromAgencyAndReturnSize1() {

		// given

		AgencyTO savedAgency = dataCreator.saveNewAgencyPoznan();
		EmployeeTO savedEmployee = dataCreator.saveNewEmployeeKrzysztof();
		EmployeeTO savedEmployee2 = dataCreator.saveNewEmployeeKrzysztof();

		agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee.getId());
		agencyService.addEmployeeToAgency(savedAgency.getId(), savedEmployee2.getId());
		Set<EmployeeTO> employees = agencyService.findEmployeesByAgencyId(savedAgency.getId());

		assertNotNull(employees);
		assertEquals(2, employees.size());
		assertTrue(employees.stream().anyMatch(employee -> employee.getId() == savedEmployee.getId()));
		assertTrue(employees.stream().anyMatch(employee -> employee.getId() == savedEmployee2.getId()));
		// when

		try {
			agencyService.deleteEmpoyeeFromAgency(savedAgency.getId(), savedEmployee.getId());
		} catch (ObjectNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employees = agencyService.findEmployeesByAgencyId(savedAgency.getId());
		// then

		assertNotNull(employees);
		assertEquals(1, employees.size());
		assertFalse(employees.stream().anyMatch(employee -> employee.getId() == savedEmployee.getId()));
		assertTrue(employees.stream().anyMatch(employee -> employee.getId() == savedEmployee2.getId()));

	}

}
