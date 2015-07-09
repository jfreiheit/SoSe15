package sose15.vorbereitungen.uebungen.uebung0707_1;

public class Counter2 extends Thread{
	int result = 0;
	
	@Override
	public void run()
	{
		for(int i = 0; i<100000; i++)
		{
			result+=i;
		}
		System.out.println("Counter 2 : " + result);
	}

}
