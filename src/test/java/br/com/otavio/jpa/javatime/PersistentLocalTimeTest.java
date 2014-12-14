package br.com.otavio.jpa.javatime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class PersistentLocalTimeTest {

	private PersistentLocalTime converter;

	@Before
	public void setup() {
		converter = new PersistentLocalTime();
	}

	@Test
	public void shouldConvertToDatabaseAsNullWhenInputIsNull() {
		Time converted = converter.convertToDatabaseColumn(null);
		assertThat(converted, is(nullValue()));
	}

	@Test
	public void shouldConvertToDatabaseWithInputValue() {
		LocalTime input = LocalTime.of(10, 15, 20, 0);
		Time converted = converter.convertToDatabaseColumn(input);

		Calendar c = new GregorianCalendar(1970, Calendar.JANUARY, 1, 10, 15, 20);
		Time expected = new Time(c.getTimeInMillis());

		assertThat(converted, is(expected));
	}

	@Test
	public void shouldConvertToEntityAsNullWhenInputIsNull() {
		LocalTime converted = converter.convertToEntityAttribute(null);
		assertThat(converted, is(nullValue()));
	}

	@Test
	public void shouldConvertToEntityWithInputValue() {
		Calendar input = new GregorianCalendar(2010, Calendar.JANUARY, 1, 10, 15, 20);
		Time sqlDate = new Time(input.getTimeInMillis());

		LocalTime expected = LocalTime.of(10, 15, 20, 0);

		LocalTime converted = converter.convertToEntityAttribute(sqlDate);
		assertThat(converted, is(expected));
	}
}
