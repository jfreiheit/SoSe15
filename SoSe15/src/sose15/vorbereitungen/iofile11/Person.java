package sose15.vorbereitungen.iofile11;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
	private final String name;
	private final String city;
	private final LocalDate birthday;
	
	Person(final String name, final String city, final String birthday)
	{
		Objects.requireNonNull(name, "name must not be null");
		Objects.requireNonNull(city, "city must not be null");
		Objects.requireNonNull(birthday, "birthday must not be null");
		this.name=name;
		this.city=city;
		this.birthday = LocalDate.parse(birthday);
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
}
