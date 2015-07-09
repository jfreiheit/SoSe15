package sose15.vorbereitungen.uebungen.threads;

import java.awt.Point;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FirstThread {

	public static void main(String[] args) throws InterruptedException 
	{
/*		Thread t1 = new DatePrint1();
		Thread t2 = new Thread(new DatePrint2());
		t1.start();
		t2.start();

		Counter1 c1 = new Counter1();
		Counter2 c2 = new Counter2();
		c1.start();
		c2.start();
		
		c1.join();
		c2.join();
		
		System.out.println("Summe   : " + (c1.result + c2.result));*/
		
		final Lock lock = new ReentrantLock();
		final Point p = new Point();

		Runnable r = new Runnable()
		{
		  @Override public void run()
		  {
		    int x = (int)(Math.random() * 1000), y = x;

		    while ( true )
		    {
		    	lock.lock();
		    		p.x = x; p.y = y;            // schreiben
		    		int xc = p.x, yc = p.y;      // lesen
		    	lock.unlock();
		    	
		    	if ( xc != yc )
		    		System.out.println( "Aha: x=" + xc + ", y=" + yc );
		    }
		  }
		};

		new Thread( r ).start();
		new Thread( r ).start();

	}

}
