package psn.ph.calendar;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestWeekChecker {

	@Test
	public void test() {
		WeekChecker wc = new WeekChecker();
		Date d1 = wc.getDate(2018, Calendar.JANUARY, 4, 5); // int year, int month, int wom, int dow
		assertEquals(26, d1.getDate());
		assertEquals(Calendar.JANUARY, d1.getMonth());
		assertEquals(2018, d1.getYear() + 1900);

		d1 = wc.getDate(2017, Calendar.MARCH, 0, 4); // int year, int month, int wom, int dow
		assertEquals(30, d1.getDate());
		assertEquals(Calendar.MARCH, d1.getMonth());
		assertEquals(2017, d1.getYear() + 1900);

	}

}
