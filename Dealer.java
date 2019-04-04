package blackjack;
import java.util.*;

public class Dealer extends Gambler {
	
	public Dealer(List<Card> ch) {
		super(ch);
	}
	
	/**
	 * @return the string of the dealer's hand, the first card is hidden
	 */
	
	public String printHand() {
		
		String str = "";
		for(int i = 0; i < currentHand.size(); i++) {
			if(i == 0)
				str += "(Mystery card), ";
			else
				str += currentHand.get(i);
		}
		
		return str;
		
	}
	
	/**
	 * @return the string of the dealer's hand including the mystery card
	 */
	
	public String printFullHand() {
		String str = "";
		for(int i = 0; i < currentHand.size(); i++) {
			if(i == currentHand.size()-1)
				str += currentHand.get(i);
			else
				str += currentHand.get(i) + ", ";
		}
		return str;
	}
}