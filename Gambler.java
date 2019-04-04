package blackjack;
import java.util.List;
import blackjack.Card.Values;

/**
 * A class that describes the properties of a player in Blackjack
 * 
 * @since 3/13/2019
 * @author Collin
 */

abstract class Gambler {
	
	protected List<Card> currentHand;
	
	/**
	 * @param ch The current player's hand
	 */
	
	public Gambler(List<Card> ch) {
		currentHand = ch;
	}
	
	abstract String printHand();
	
	/**
	 * Calculates the sum of a player's hand
	 * @return The sum of the player's hand
	 */
	
	public int handSum() {
		
		int sum = 0;
		
		try {
			for(int i = 0; i < currentHand.size(); i++) {
				sum += convertCardToValue(currentHand.get(i));
			}	
		} catch(StackOverflowError e) {
			if(sum > 10)
				return 1;
			else
				return 11;
		}
		
		return sum;
	}
	
	public String printSum() {
		return " Sum: " + handSum();
	}
	
	/**
	 * Turns a card into a usable amount
	 * 
	 * @return The value of the card or -1 if the card is not recognized.
	 */
	
	public int convertCardToValue(Card card) {
		
		if(card.getValue() == Values.ACE) {
			if(handSum() >= 10)
				return 1;
			else
				return 11;
		}
		else if(card.getValue() == Values.TWO) {
			return 2;
		}
		else if(card.getValue() == Values.THREE) {
			return 3;
		}
		else if(card.getValue() == Values.FOUR) {
			return 4;
		}
		else if(card.getValue() == Values.FIVE) {
			return 5;
		}
		else if(card.getValue() == Values.SIX) {
			return 6;
		}
		else if(card.getValue() == Values.SEVEN) {
			return 7;
		}
		else if(card.getValue() == Values.EIGHT) {
			return 8;
		}
		else if(card.getValue() == Values.NINE) {
			return 9;
		}
		else if(card.getValue() == Values.TEN || card.getValue() == Values.JACK || card.getValue() == Values.QUEEN || card.getValue() == Values.KING) {
			return 10;
		}
		
		return -1;
		
	}
	
}