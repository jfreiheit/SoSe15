package sose15.vorbereitungen.uebungen.uebung2;

import java.util.Objects;

public abstract class Currency {
	String name;
	String country;
	
	Currency(final String name, final String country)
	{
		Objects.requireNonNull(name, "name must not be null");
		Objects.requireNonNull(country, "country must not be null");
		this.name = name;
		this.country = country;
	}
	
	public abstract double dollarValue();
	public abstract double euroValue();

}
