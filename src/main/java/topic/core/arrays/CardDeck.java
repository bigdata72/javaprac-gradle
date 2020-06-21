package topic.core.arrays;

import java.util.Arrays;

/**
 * write a program to pick 4 cards in random from a deck of cards
 */
public class CardDeck {
	private int [] deck = new int[52];
	private String [] suits = {"Spades", "Hearts", "Diamond", "Clubs"};
	private String [] value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
	"Jack", "Queen", "King"};
	
	public CardDeck(){
		for(int i=0; i<deck.length; i++){
			deck[i] = i;
		}
	}
	
	public void printDeck(){
		System.out.println(Arrays.toString(deck));
	}
	
	public static void main(String[] args) {
		CardDeck deckOfCard = new CardDeck();
		System.out.println("Deck before shuffle=");
		deckOfCard.printDeck();
		
		// suits : spades, heart, diamond, clubs
		// 0-12 = Spades
		// 13-25 = Hearts
		// 26-38 = Diamonds
		// 39-51 = Clubs
		// Each suit has the following card denominations
		// 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King and Ace
		deckOfCard.shuffle();
		System.out.println("Deck after shuffle=");
		deckOfCard.printDeck();
		// deal 4 cards
		System.out.println("Hand dealt is =");
		deckOfCard.deal(4);
		
	}
	
	private void printHand(int index){
		System.out.printf("Card %s = %s of %s %n", index, value[index%13], suits[index/13]);
	}
	
	private void deal(int numCards){
		
//		for(int i=0;i<numCards;i++){
//			printHand(deck[i]);
//		}
		
		for (int i = 0; i < numCards; i++) {
			int cardNumber = (int)(Math.random() * deck.length);
			printHand(cardNumber);
		}

	}
	
	private void shuffle(){
		for(int i=0; i<deck.length; i++) {
			int j = (int) (Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
}
