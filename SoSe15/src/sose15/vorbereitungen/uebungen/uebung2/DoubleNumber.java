package sose15.vorbereitungen.uebungen.uebung2;

public class DoubleNumber  extends PositiveNumber implements MyComparable, MyPrintable{
	private double value;

	DoubleNumber(final double value)
	{
		if(value<0)
			this.value=-value;
		else
			this.value=value;
	}
	
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof PositiveNumber)
		{
			PositiveNumber comparedTo = (PositiveNumber)o;
			if(this.doubleValue()>comparedTo.doubleValue()) return 1;
			else if(this.doubleValue()<comparedTo.doubleValue()) return -1;
			else return 0;
		}
		return Integer.MIN_VALUE;
	}

	@Override
	public double doubleValue() {
		return this.value;
	}

	@Override
	public int intValue() {
		return (int)this.value;
	}
	
	@Override
	public void printValue()
	{
		System.out.println(this.doubleValue());
	}

	@Override
	public void printComparison(Object o) {
		String text = "";
		int result = this.compareTo(o);
		switch(result)
		{
			case 1: text += (this.doubleValue() + " > " + ((PositiveNumber)o).doubleValue()); break;
			case 0: text += (this.doubleValue() + " == " + ((PositiveNumber)o).doubleValue()); break;
			case -1: text += (this.doubleValue() + " < " + ((PositiveNumber)o).doubleValue()); break;
			case Integer.MIN_VALUE: text += "not comparable"; break;
		}
		System.out.println(text);
	}
}
