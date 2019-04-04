package blackjack;
import java.util.*;

public class Player extends Gambler {
	
	public Player(List<Card> ch) {
		super(ch);
	}
	
	/**
	 * @returns the string of the player's hand
	 */
	
	public String printHand() {
		
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