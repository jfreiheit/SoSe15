package sose15.aufgaben.aufgabe2.freiheit;

public class SortedSet implements MyPrintable, MyComparable{
	Integer[] set;

	SortedSet()
	{
		set = new Integer[0];
	}

	boolean exists(Integer number)
	{
		for(Integer n : set)
		{
			if(n.intValue()==number.intValue()) return true;
		}
		return false;
	}

	boolean exists(int number)
	{
		if(this.set.length>0)
		{
			for(Integer n : this.set)
			{
				if(n.intValue()==number) return true;
			}
		}
		return false;
	}

	boolean insert(Integer number)
	{
		boolean inserted = false;
		if(!exists(number))
		{
			if(this.set.length==0)
			{
				this.set = new Integer[]{number};
			}
			else
			{
				Integer[] newSet = new Integer[this.set.length+1];
				int indexNewSet=0;
				int index = 0;
				while(index<this.set.length && set[index].intValue()<number.intValue())
				{
					newSet[indexNewSet++]=set[index++];
				}
				newSet[indexNewSet++]=number;
				while(index<this.set.length)
				{
					newSet[indexNewSet++]=set[index++];
				}
				this.set = newSet;
			}
			//this.printAll();
			inserted = true;
		}
		return inserted;	}

	boolean insert(int number)
	{
		boolean inserted = false;
		if(!exists(number))
		{
			if(this.set.length==0)
			{
				this.set = new Integer[]{Integer.valueOf(number)};
			}
			else
			{
				Integer[] newSet = new Integer[this.set.length+1];
				int indexNewSet=0;
				int index = 0;
				while(index<this.set.length && set[index].intValue()<number)
				{
					newSet[indexNewSet++]=set[index++];
				}
				newSet[indexNewSet++]=Integer.valueOf(number);
				while(index<this.set.length)
				{
					newSet[indexNewSet++]=set[index++];
				}
				this.set = newSet;
			}
			//this.printAll();
			inserted = true;
		}
		return inserted;
	}

	boolean remove(Integer number)
	{
		boolean removed = false;
		if(exists(number))
		{
			Integer[] newSet = new Integer[this.set.length-1];
			int indexNewSet=0;
			for(Integer n : set)
			{
				if(n.intValue()!=number.intValue())
					newSet[indexNewSet++]=n;
			}
			this.set = newSet;
			removed = true;
		}
		return removed;
	}

	boolean remove(int number)
	{
		boolean removed = false;
		if(exists(number))
		{
			Integer[] newSet = new Integer[this.set.length-1];
			int indexNewSet=0;
			for(Integer n : set)
			{
				if(n.intValue()!=number)
					newSet[indexNewSet++]=n;
			}
			this.set = newSet;
			removed = true;
		}
		return removed;
	}

	boolean insert(SortedSet s)
	{
		boolean allInserted = true;
		for(Integer i : s.set)
		{
			if(allInserted) allInserted = insert(i);
			else insert(i);		// keep allInserted false
		}
		return allInserted;		
	}

	@Override
	public boolean equal(Object set) 
	{
		boolean equal = false;
		if(set instanceof SortedSet && this.set.length == ((SortedSet)set).set.length)
		{
			equal = true;
			for(int index=0; index<this.set.length && equal; index++)
				equal = (this.set[index].intValue()==((SortedSet)set).set[index].intValue());
		}
		return equal;
	}

	@Override
	public void printElement(Object element) {
		if(element instanceof Integer && exists((Integer)element))
			System.out.println((Integer)element);
		else
			System.out.println("not a number or not in the set");
	}

	@Override
	public void printElement(int index) {
		if(index>=0 && index<this.set.length)
			System.out.println(this.set[index]);
		else
			System.out.println("index out of bounds");

	}

	@Override
	public void printAll() 
	{
		System.out.print(this.set.length + " : [ ");
		for(int index = 0; index<this.set.length-1; index++)
		{
			System.out.print(this.set[index] + ", ");
		}
		if(this.set.length>0)
			System.out.println(this.set[this.set.length-1] + " ]");
		else
			System.out.println("]");

	}

}
