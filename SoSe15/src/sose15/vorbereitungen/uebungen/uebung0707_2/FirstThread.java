package sose15.vorbereitungen.uebungen.uebung0707_2;

import java.awt.Point;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FirstThread {

	public static void main(String[] args) throws InterruptedException {
/*		Thread t1 = new DatePrint1();				// extends Thread
		Thread t2 = new Thread(new DatePrint2());	// implements Runnable
		t1.start();
		t2.start();*/
		
/*		Counter1 c1 = new Counter1();
		Counter2 c2 = new Counter2();
		LocalTime start = LocalTime.now();
		c1.start();
		c2.start();		
		
		c1.join();	
		c2.join();
		LocalTime end = LocalTime.now();
		Duration dauer = Duration.between(start, end);
		
		System.out.println("Summe : " + (c1.result + c2.result) + " in " + dauer);*/
		
		final Point p = new Point();	
		final Lock myLock = new ReentrantLock();
		
		Runnable r = new Runnable(){
			@Override
			public void run() 
			{
				int x = (int)(Math.random() * 1000);
				int y = x;
				
				while(true)
				{
					myLock.lock();
						// schreiben auf p
						p.x = x;
						p.y = y;
						// lesen aus p
						int xc = p.x;
						int yc = p.y;
					myLock.unlock();
					
					if(xc!=yc)
					{
						System.out.println("x = " + xc + " y = " + yc);
					}
					else
					{
						System.out.println("xc und yc sind gleich");
					}
				}	
			}
		};
		
		new Thread(r).start();
		new Thread(r).start();

	}

}
