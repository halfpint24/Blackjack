package blackjack;
import java.util.*;

/**
 * This class contains info about a playing card originally made to be used in Blackjack, but can be used in other card games as well.
 * 
 * @since 3/13/2019
 * @author Collin Padgett
 */

public class Card {
	
	enum Suits {
		SPADES, CLUBS, DIAMONDS, HEARTS
	}
	
	enum Values {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
	
	private Suits suit;
	private Values value;
	
	/**
	 * This constructor is used only to create an object to access the methods in this class
	 */
	
	public Card() {};
	
	/**
	 * This constructor is used in the makeDeck method to add suits and values to cards
	 * @param s the suit of the card
	 * @param v the value of the card
	 */
	
	public Card(Suits s, Values v) {
		
		suit = s;
		value = v;
		
	}
	
	/**
	 * Makes a deck of cards.
	 * @return a list of 52 cards.
	 */
	
	public List<Card> makeDeck() {
		
		List<Card> deck = new ArrayList<Card>();
		
		for(Suits s : Suits.values()) {
			for(Values v : Values.values()) {
				deck.add(new Card(s, v));
			}
		}
		
		return deck;
		
	}
	
	public Suits getSuit() {
		
		return suit;
		
	}
	
	public Values getValue() {
		
		return value;
		
	}
	
	public String toString() {
		
		return value + " of " + suit;
		
	}
	
}
