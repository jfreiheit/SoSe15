package sose15.vorbereitungen.uebungen.threads;

public class Counter1 extends Thread{
	int result = 0;

	@Override
	public void run()
	{
		for(int i=0; i<100000; i++)
		{
			result+=i;
		}
		System.out.println("Counter 1: " + result);
	}
}
