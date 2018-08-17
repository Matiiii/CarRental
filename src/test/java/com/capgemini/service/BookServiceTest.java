package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.types.AuthorTO;
import com.capgemini.types.AuthorTO.AuthorTOBuilder;
import com.capgemini.types.BookTO;
import com.capgemini.types.BookTO.BookTOBuilder;
import com.capgemini.types.CarTO;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class BookServiceTest {

	@Autowired
	private BookService bookService;

	@Autowired
	private CarService carService;

	@Test
	@Transactional
	public void testShouldFindBookById() {

		// given
		String bookTitle = "Herr Tadeusz";
		AuthorTO author = new AuthorTOBuilder().withFirstName("Adam").withLastName("Mickiewicz").build();
		BookTO panTadeuszBook = new BookTOBuilder().withTitle(bookTitle).withAuthor(author).build();
		BookTO savedBook = bookService.saveBook(panTadeuszBook);

		// when
		BookTO selectedBook = bookService.findBookById(savedBook.getId());

		// then
		assertNotNull(selectedBook);
		assertEquals(savedBook.getAuthors(), selectedBook.getAuthors());
		assertEquals(savedBook.getTitle(), selectedBook.getTitle());
	}

	@Test
	@Transactional
	public void testShouldFindBooksById() {

		// given
		String bookTitle = "Herr Tadeusz";
		AuthorTO author = new AuthorTOBuilder().withFirstName("Adam").withLastName("Mickiewicz").build();
		BookTO panTadeuszBook = new BookTOBuilder().withTitle(bookTitle).withAuthor(author).build();
		bookService.saveBook(panTadeuszBook);

		// when
		List<BookTO> selectedBooks = bookService.findBooksByTitle(bookTitle);

		// then
		assertNotNull(selectedBooks);
		assertFalse(selectedBooks.isEmpty());
		assertTrue(selectedBooks.stream().anyMatch(b -> b.getTitle().equals(bookTitle)));
	}

	@Test
	@Transactional
	public void testShouldFindBooksByAuthor() {

		// given
		String bookTitle = "Herr Tadeusz";
		AuthorTO author = new AuthorTOBuilder().withFirstName("Adam").withLastName("Mickiewicz").build();
		BookTO panTadeuszBook = new BookTOBuilder().withTitle(bookTitle).withAuthor(author).build();
		BookTO savedBook = bookService.saveBook(panTadeuszBook);

		// when
		List<BookTO> selectedBooks = bookService.findBooksByAuthor(savedBook.getAuthors().iterator().next().getId());

		// then
		assertNotNull(selectedBooks);
		assertTrue(selectedBooks.stream().anyMatch(b -> b.getTitle().equals(bookTitle)));
	}

	@Test
	public void shouldGetAutoById() {

		// given
		Set<Long> rents = new HashSet<>();

		Set<Long> caregivers = new HashSet<>();

		CarTO carAudi = CarTO.builder().agency(1L).brand("Audi").agency(1L).color("Czarny").engineCapacity(2.5F)
				.mileage(20034).power(320).rents(rents).caregivers(caregivers).type("kombi").build();
		CarTO savedCar = carService.saveNewCar(carAudi);
		// when

		CarTO selectedCar = carService.findCarById(savedCar.getId());

		// then
		assertNotNull(selectedCar);
		assertEquals(savedCar.getId(), selectedCar.getId());
		assertEquals(savedCar.getBrand(), selectedCar.getBrand());

	}

	@Test
	public void shouldUpdatedAutoById() {

		// given

		Set<Long> rents = new HashSet<>();

		Set<Long> caregivers = new HashSet<>();

		CarTO carAudi = CarTO.builder().agency(1L).brand("Audi").color("Zielony").engineCapacity(2.5F).mileage(20034)
				.power(320).rents(rents).caregivers(caregivers).type("kombi").build();

		CarTO savedCar = carService.saveNewCar(carAudi);

		CarTO carAudi2 = CarTO.builder().id(savedCar.getId()).agency(1L).brand("Audi").color("Czerwony")
				.engineCapacity(2.5F).mileage(20034).power(320).rents(rents).caregivers(caregivers)
				.version(savedCar.getVersion()).type("kombi").build();

		// when
		CarTO updatedCar = carService.update(carAudi2);

		// then
		assertNotNull(updatedCar);
		assertEquals(savedCar.getId(), updatedCar.getId());
		assertEquals(carAudi2.getColor(), updatedCar.getColor());

	}

}
