package br.com.otavio.jpa.javatime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class PersistentLocalDateTest {

	private PersistentLocalDate converter;

	@Before
	public void setup() {
		converter = new PersistentLocalDate();
	}

	@Test
	public void shouldConvertToDatabaseAsNullWhenInputIsNull() {
		Date converted = converter.convertToDatabaseColumn(null);
		assertThat(converted, is(nullValue()));
	}

	@Test
	public void shouldConvertToDatabaseWithInputValue() {
		LocalDate input = LocalDate.of(2010, Month.JANUARY, 1);
		Date converted = converter.convertToDatabaseColumn(input);

		Calendar c = new GregorianCalendar(2010, Calendar.JANUARY, 1, 0, 0, 0);
		Date expected = new Date(c.getTimeInMillis());

		assertThat(converted, is(expected));
	}

	@Test
	public void shouldConvertToEntityAsNullWhenInputIsNull() {
		LocalDate converted = converter.convertToEntityAttribute(null);
		assertThat(converted, is(nullValue()));
	}

	@Test
	public void shouldConvertToEntityWithInputValue() {
		Calendar input = new GregorianCalendar(2010, Calendar.JANUARY, 1, 0, 0, 0);
		Date fromSQL = new Date(input.getTimeInMillis());

		LocalDate expected = LocalDate.of(2010, Month.JANUARY, 1);

		LocalDate converted = converter.convertToEntityAttribute(fromSQL);
		assertThat(converted, is(expected));
	}
}