package br.com.otavio.jpa.javatime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class PersistentLocalDateTimeTest {

	private PersistentLocalDateTime converter;

	@Before
	public void setup() {
		converter = new PersistentLocalDateTime();
	}

	@Test
	public void shouldConvertToDatabaseAsNullWhenInputIsNull() {
		Timestamp converted = converter.convertToDatabaseColumn(null);
		assertThat(converted, is(nullValue()));
	}

	@Test
	public void shouldConvertToDatabaseWithInputValue() {
		LocalDateTime input = LocalDate.of(2010, Month.JANUARY, 1).atTime(1, 10, 30, 0);
		Timestamp converted = converter.convertToDatabaseColumn(input);

		Calendar c = new GregorianCalendar(2010, Calendar.JANUARY, 1, 1, 10, 30);
		Timestamp expected = new Timestamp(c.getTimeInMillis());

		assertThat(converted, is(expected));
	}

	@Test
	public void shouldConvertToEntityAsNullWhenInputIsNull() {
		LocalDateTime converted = converter.convertToEntityAttribute(null);
		assertThat(converted, is(nullValue()));
	}

	@Test
	public void shouldConvertToEntityWithInputValue() {
		Calendar input = new GregorianCalendar(2010, Calendar.JANUARY, 1, 1, 10, 30);
		Timestamp sqlDate = new Timestamp(input.getTimeInMillis());

		LocalDateTime expected = LocalDate.of(2010, Month.JANUARY, 1).atTime(1, 10, 30, 0);

		LocalDateTime converted = converter.convertToEntityAttribute(sqlDate);
		assertThat(converted, is(expected));
	}
}
