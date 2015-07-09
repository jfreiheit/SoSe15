package sose15.vorbereitungen.uebungen.uebung0;

public class CardsMain {

	public static void main(String[] args) {
		Cards myCards = new Cards();
		for(int i=0; i<10; i++)
		{
			myCards.printACard();
		}
		System.out.println("----------------------");
		myCards.printSortedDeck();
		System.out.println("----------------------");
		myCards.printShuffeledDeck();
		System.out.println("----------------------");
		String[] shuffeledCards = myCards.shuffleCards();
		myCards.isSmaller(shuffeledCards[0], shuffeledCards[1]);
		myCards.collectPlay(Plays.FLUSH);

	}

}
