package sose15.vorbereitungen.uebungen.uebung0707_2;

import java.time.LocalDateTime;

public class DatePrint2 implements Runnable{

	@Override
	public void run() {
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Current time 2 : " + time);
		for(int i=0; i<200; i++)
		{
			time = LocalDateTime.now();
			System.out.println("Dateprint 2 : " + time);
		}
		
	}

}
