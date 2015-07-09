package sose15.vorbereitungen.uebungen.uebung6;

public class Controller {
	Kurse kurse;
	MainView view;
	
	Controller()
	{
		kurse = new Kurse();
		//test
		kurse.add(new Kurs("kurs1", 10));
		kurse.add(new Kurs("kurs2", 8));
		kurse.add(new Kurs("kurs3", 6));
		kurse.add(new Kurs("kurs4", 12));
		kurse.add(new Kurs("kurs5", 14));
		kurse.add(new Kurs("kurs6", 18));
		
		view = new MainView(kurse);
	}
	
	public static void main(String[] args) 
	{
		new Controller();
	}

}
