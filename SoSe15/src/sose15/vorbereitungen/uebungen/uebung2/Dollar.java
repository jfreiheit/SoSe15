package sose15.vorbereitungen.uebungen.uebung2;

import java.util.Objects;

public class Dollar extends Currency implements MyComparable{
	String small;

	Dollar(final String small) {
		super("Dollar", "USA");
		Objects.requireNonNull(small, "small must not be null");
		this.small = "Cent";
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Currency)
		{
			Currency c = (Currency)o;
			double eps = 0.001;
			double diff = this.dollarValue()-c.dollarValue();
			if (Math.abs(diff) < eps)
			{
				return 0;
			}
			else 
				if(diff < 0)
				{
					return -1;
				}
				else
				{
					return 1;
				}

		}
		else return Integer.MIN_VALUE;
	}

	@Override
	public double dollarValue() {
		return 1.0;
	}

	@Override
	public double euroValue() {
		return 0.930440284;
	}

}
