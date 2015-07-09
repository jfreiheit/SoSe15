package sose15.vorbereitungen.uebungen.threads;

import java.time.LocalDateTime;

public class DatePrint1 extends Thread
{
	@Override
	public void run() {
		LocalDateTime time = LocalDateTime.now();
        System.out.println("Current Time 1="+time);
		for(int i=0; i<200; i++)
		{
			time = LocalDateTime.now();
			System.out.println("DatePrint 1 : " + time);
		}	
	}
}
