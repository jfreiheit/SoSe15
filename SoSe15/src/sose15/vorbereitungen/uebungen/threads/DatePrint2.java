package sose15.vorbereitungen.uebungen.threads;

import java.time.LocalDateTime;

public class DatePrint2 implements Runnable
{

	@Override
	public void run() {
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Current Time 2="+time);
		for(int i=0; i<200; i++)
		{
			time = LocalDateTime.now();
			System.out.println("DatePrint 2 : " + time);
		}	
	}
}
