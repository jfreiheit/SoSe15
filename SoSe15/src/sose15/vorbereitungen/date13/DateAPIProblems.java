package sose15.vorbereitungen.date13;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAPIProblems {

	public static void main(String[] args) {
		final int year = 1990;
		final int month = 7;
		final int day = 28;
		System.out.println(new Date(year,month,day));
		System.out.println(LocalDate.of(year, month, day));
		
		Calendar calendar1 = new GregorianCalendar(1990, 7, 28);
		System.out.println(calendar1.getTime());
		
		Calendar calendar2 = new GregorianCalendar(1990, 7, 28, 13, 45);
		System.out.println(calendar2.getTime());
		
		Student_in s1 = new Student_in("Maria Mustermann", "FIW", 1990, 2, 28);
		s1.print();
		
		LocalDate jetzt = LocalDate.now();
		LocalDate weihnachten = LocalDate.of(2015, Month.DECEMBER, 24);
		LocalDate ostern = LocalDate.parse("2015-04-05");
		
		System.out.println(jetzt);
		System.out.println(weihnachten);
		System.out.println(ostern);
	}

}
