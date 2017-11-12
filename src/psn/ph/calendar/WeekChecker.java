package psn.ph.calendar;

import java.util.Calendar;
import java.util.Date;

public class WeekChecker {

	public Date getDate(int year, int month, int wom, int dow) {
		dow = dow % 7;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		long minTime = calendar.getTimeInMillis();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		long maxTime = calendar.getTimeInMillis();
		if (wom == 0) {
			// handle special case of last week of month instead of 1 - 4
			calendar.set(Calendar.WEEK_OF_MONTH, calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));
		} else {
			calendar.set(Calendar.WEEK_OF_MONTH, wom);
		}
		calendar.set(Calendar.DAY_OF_WEEK, dow + 1); // +1 due to offset to DOW definition
		// ensure that we always remain within the month of focus
		if (calendar.getTimeInMillis() < minTime) {
			calendar.add(Calendar.DAY_OF_YEAR, 7);
		} else if (calendar.getTimeInMillis() > maxTime) {
			calendar.add(Calendar.DAY_OF_YEAR, -7);
		}
		return calendar.getTime();
	}

	public static void main(String[] args) {
		WeekChecker weekChecker = new WeekChecker();
		int year = Integer.parseInt(args[0]);
		int wom = Integer.parseInt(args[1]);
		int dow = Integer.parseInt(args[2]);
		System.out.println("year: " + year + ", wom: " + wom + ", dow: " + dow);
		for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++) {
			System.out.println(weekChecker.getDate(year, month, wom, dow));
		}
	}
}
