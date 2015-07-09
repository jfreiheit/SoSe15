package sose15.vorbereitungen.uebungen.uebung0;

import java.util.Random;

public class Cards {
	String[] suit = {"Diamonds", "Hearts", "Spades", "Clubs"};
	String[] rank = {"7", "8", "9", "10", "J", "Q", "K", "A"};
	Random r = new Random();
	
	String takeACard()
	{
		int color = r.nextInt(suit.length);
		int number = r.nextInt(rank.length);
		return rank[number]+" of "+suit[color];
	}
	
	void printACard()
	{
		System.out.println(this.takeACard());
	}
	
	String[] sortedDeck()
	{
		String[] deck = new String[suit.length * rank.length];
		for(int i=0; i<suit.length; i++)
		{
			for(int j=0; j<rank.length; j++)
			{
				deck[rank.length*i+j]=rank[j]+" of "+ suit[i];
			}
		}
		return deck;
	}
	
	void printSortedDeck()
	{
		String[] deck = this.sortedDeck();
		for(int i=0; i<deck.length; i++)
		{
			System.out.println(deck[i]);
		}
	}
	
	String[] shuffleCards()
	{
		String[] deck = this.sortedDeck();
		int source, target = 0;
		String memorize="";
		for(int i=0; i<deck.length; i++)
		{
			source = r.nextInt(deck.length);
			target = r.nextInt(deck.length);
			memorize = deck[target];
			deck[target]=deck[source];
			deck[source]=memorize;
		}
		return deck;
	}
	
	void printShuffeledDeck()
	{
		String[] deck = this.shuffleCards();
		for(int i=0; i<deck.length; i++)
		{
			System.out.println(deck[i]);
		}
	}
	
	int indexOfSuit(String card)
	{
		String[] cardTokens = card.split(" ");
		for(int i=0; i<suit.length; i++)
		{
			if(suit[i].equals(cardTokens[2]))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	int indexOfRank(String card)
	{
		String[] cardTokens = card.split(" ");
		for(int i=0; i<rank.length; i++)
		{
			if(rank[i].equals(cardTokens[0]))
			{
				return i;
			}
		}
		return -1;
	}
	
	boolean isSmaller(String card1, String card2)
	{
		int indexRankCard1 = indexOfRank(card1);
		int indexRankCard2 = indexOfRank(card2);
		int indexSuitCard1 = indexOfSuit(card1);
		int indexSuitCard2 = indexOfSuit(card2);
		return ((indexSuitCard1 * 1000 + indexRankCard1) < (indexSuitCard2 * 1000 + indexRankCard2));
	}
	
	boolean isEqual(String card1, String card2)
	{
		int indexRankCard1 = indexOfRank(card1);
		int indexRankCard2 = indexOfRank(card2);
		int indexSuitCard1 = indexOfSuit(card1);
		int indexSuitCard2 = indexOfSuit(card2);
		return ((indexSuitCard1 * 1000 + indexRankCard1) == (indexSuitCard2 * 1000 + indexRankCard2));
	}
	
	void collectPlay(Plays play)
	{
		int tries=0;
		String[] deck = this.shuffleCards();
		String[] taken;
		int index, takenindex = 0;
		String rank,suit = "";
		switch(play)
		{
			case ONEPAIR 	: 	taken = new String[2]; 
								index = r.nextInt(deck.length);
								rank = deck[index].split(" ")[0];
								taken[takenindex++] = deck[index];
								deck[index]= "";
								while(takenindex<2)
								{
									index = r.nextInt(deck.length);
									if(!deck[index].equals(""))
										rank = deck[index].split(" ")[0];
									else 
										rank="";
									tries++;
									if(rank.equals(taken[0].split(" ")[0]))
									{
										taken[takenindex++] = deck[index];										
									}
								}
								this.printDeck(taken);
								System.out.println(" ; Versuche : " + tries);
								break;
			case TWOPAIRS	: 
			case FOURS 		: 	taken = new String[4]; 
								index = r.nextInt(deck.length);
								rank = deck[index].split(" ")[0];
								taken[takenindex++] = deck[index];
								deck[index]= "";
								while(takenindex<4)
								{
									index = r.nextInt(deck.length);
									if(!deck[index].equals(""))
										rank = deck[index].split(" ")[0];
									else 
										rank="";
									tries++;
									if(rank.equals(taken[0].split(" ")[0]))
									{
										taken[takenindex++] = deck[index];										
									}
								}
								this.printDeck(taken);
								System.out.println(" ; Versuche : " + tries);
								break;
			case THREES 	: 	taken = new String[3]; 
								index = r.nextInt(deck.length);
								rank = deck[index].split(" ")[0];
								taken[takenindex++] = deck[index];
								deck[index]= "";
								while(takenindex<3)
								{
									index = r.nextInt(deck.length);
									if(!deck[index].equals(""))
										rank = deck[index].split(" ")[0];
									else 
										rank="";
									tries++;
									if(rank.equals(taken[0].split(" ")[0]))
									{
										taken[takenindex++] = deck[index];										
									}
								}
								this.printDeck(taken);
								System.out.println(" ; Versuche : " + tries);
								break;
			case FULLHOUSE	:  
			case FLUSH		: 	taken = new String[5]; 
								index = r.nextInt(deck.length);
								suit = deck[index].split(" ")[2];
								taken[takenindex++] = deck[index];
								deck[index]= "";
								while(takenindex<5)
								{
									index = r.nextInt(deck.length);
									if(!deck[index].equals(""))
										suit = deck[index].split(" ")[2];
									else 
										suit="";
									tries++;
									if(suit.equals(taken[0].split(" ")[2]))
									{
										taken[takenindex++] = deck[index];										
									}
								}
								this.printDeck(taken);
								System.out.println(" ; Versuche : " + tries);
								break;
			case STRAIGHTFLUSH: 
			case STRAIGHT 	: 	taken = new String[5]; 
								index = r.nextInt(deck.length);
								rank = deck[index].split(" ")[0];
								taken[takenindex++] = deck[index];
								deck[index]= "";
								while(takenindex<5)
								{
									index = r.nextInt(deck.length);
									if(!deck[index].equals(""))
										rank = deck[index].split(" ")[2];
									else 
										rank="";
									tries++;
									if(suit.equals(taken[0].split(" ")[2]))
									{
										taken[takenindex++] = deck[index];										
									}
								}
								this.printDeck(taken);
								System.out.println(" ; Versuche : " + tries);
								break;
			default			: 	System.out.println("Play undefined!"); 
		}
	}
	
	void printDeck(String[] deck)
	{
		for(int i=0; i<deck.length-1; i++)
		{
			System.out.print(deck[i]+", ");
		}
		System.out.print(deck[deck.length-1]+" ");
	}
}
