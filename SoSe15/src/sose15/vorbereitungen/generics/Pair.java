package sose15.vorbereitungen.generics;

public class Pair<T extends Number> {
	private final T first;
	private final T second;

	public Pair(final T first, final T second) {
		this.first = first;
		this.second = second;
	}
	public T getFirst() {
		return first;
	}
	public T getSecond() {
		return second;
	}
	
	public Pair<T> sum(Pair<T> p)
	{
		if(p.first instanceof Double)
		{
			double f1 = this.first.doubleValue();
			double s1 = this.second.doubleValue();
			double f2 = p.first.doubleValue();
			double s2 = p.second.doubleValue();
			Pair<Double> result = new Pair<Double>(Double.valueOf(f1+f2), Double.valueOf(s1+s2));
			return (Pair<T>)result;
		}
		else if(p.first instanceof Integer)
		{
			int f1 = this.first.intValue();
			int s1 = this.second.intValue();
			int f2 = p.first.intValue();
			int s2 = p.second.intValue();
			Pair<Integer> result = new Pair<>(Integer.valueOf(f1+f2), Integer.valueOf(s1+s2));
			return (Pair<T>)result;
		}
		return this;
	}
	
	@Override
	public String toString()
	{
		return "(" + this.first.toString() + ", " + this.second.toString() + ")";
	}
}
