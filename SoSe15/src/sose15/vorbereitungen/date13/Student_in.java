package sose15.vorbereitungen.date13;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class Student_in {
	private String name;
	private String course;
	private LocalDate immaDate;
	private LocalDate birthDay;
	
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public LocalDate getImmaDate() {
		return immaDate;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	public Student_in(final String name, final String course, final int birthyear, final int birthmonth, final int birthday)
	{
		Objects.requireNonNull(name, "name must not be null");
		Objects.requireNonNull(course, "course must not be null");
		this.name=name;
		this.course=course;
		this.immaDate = LocalDate.now();
		this.birthDay = LocalDate.of(birthyear, birthmonth, birthday);
	}
	
	void printBirthday()
	{
		System.out.printf("geb. am : %s.%s.%s\n", getBirthDay().getDayOfMonth(), getBirthDay().getMonthValue(), getBirthDay().getYear());
	}
	
	void print(){
		System.out.print("Name : " + getName() + " Studiengang : " + getCourse()+ " ");
		printBirthday();
	}
	
	
}
