package sose15.aufgaben.aufgabe3.freiheit;

public class EratosthenesMain {

	public static void main(String[] args) {
		Eratosthenes era = new Eratosthenes(100);
		era.printAll();
		era.createSieve();
		era.printSieve();
		era.filter();
		era.printAll();
	}

}
