package blackjack;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * This is a Blackjack program. Rules of Blackjack can be shown by typing rules in the program. This class runs the program.
 * 
 * @since 3/13/2019
 * @author Collin Padgett
 */

public class BlackjackRunner {

	public static void main(String[] args) {
		
		gameloop:
		while(true) {
			
			Card c = new Card();
			List<Card> deck = c.makeDeck();
			Collections.shuffle(deck);

			List<Card> playerHand = new ArrayList<>();
			List<Card> dealerHand = new ArrayList<>();
			for(int i = 0; i < 2; i++) {
				playerHand.add(deck.remove(0));
				dealerHand.add(deck.remove(0));
			}

			Player p = new Player(playerHand);
			Dealer d = new Dealer(dealerHand);
			
			try {

			String res = JOptionPane.showInputDialog("Your hand:\n" + p.printHand() + p.printSum() + "\n" + printDivider() + "\n" + "Dealer's hand:\n" + d.printHand() + "\n" + printDivider() + "\nDo you want to hit or stand?\n(Type help for a list of commands.)");

			if(res.toLowerCase().equals("hit")) {
				boolean yourTurn = true;
				while(yourTurn) {
					playerHand.add(deck.remove(0));
					if(p.handSum() > 21) {
						JOptionPane.showMessageDialog(null, p.printHand() + p.printSum() + "\nOh no! You busted!", "You Busted!", JOptionPane.ERROR_MESSAGE);
						continue gameloop;
					}
					else if(p.handSum() == 21) {
						JOptionPane.showMessageDialog(null, p.printHand() + p.printSum() + "\nYes! You got a blackjack and won!", "Yay!!!!", JOptionPane.INFORMATION_MESSAGE);
						continue gameloop;
					}
					else {
						String hit = JOptionPane.showInputDialog(p.printHand() + p.printSum() + "\nWant to hit again?");
						if(hit.equals("yes") || hit.equals("hit"))
							continue;
						else
							break;
					}
				}

			}
			else if(res.toLowerCase().equals("stand")) {
				JOptionPane.showMessageDialog(null, "You decide to stand.", "Standing", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(res.toLowerCase().equals("exit")) {
				JOptionPane.showMessageDialog(null, "You left the casino.", "Bye!", JOptionPane.INFORMATION_MESSAGE);
				break gameloop;
			}
			else if(res.toLowerCase().equals("help")) {
				JOptionPane.showMessageDialog(null, "Help Screen\n" + printDivider() + "\nhit - Gives you a card from the deck.\nstand - Skips your turn with no hits taken.\nexit - Exits the game.\nrules - Shows the rules of Blackjack.", "Help", JOptionPane.INFORMATION_MESSAGE);
				continue gameloop;
			}
			else if(res.toLowerCase().equals("rules")) {
				JOptionPane.showMessageDialog(null, "Rules of Blackjack\n" + printDivider() + "\n1.)Every player gets two cards: one card is kept face down for everybody to see, \nand the other is hidden from everyone except yourself.\n2.)On your turn, you may decide to hit or stand.\nHitting is when you take a card from the deck. Standing is when you end your turn from further action.\n3.)The goal of the game is to have the value of your hand(The value of the card is the number on the card. \nAll face cards equal 10 and aces can equal a 1 or 11. ) equal 21, aka a Blackjack. \nHowever, if you go over 21, you automatically lose the game(busting).\n4.)Once everyone has had a turn, all players must reveal their cards. The player with the highest value wins. \nIf more than one player has the same winning value, they push and tie the game.\n5.)Rinse and repeat.", "Rules", JOptionPane.INFORMATION_MESSAGE);
				continue gameloop;
			}
			else {
				JOptionPane.showMessageDialog(null, "You said \"" + res + "\", but I don't know what that means.\nSo I assume you are standing.", "?????", JOptionPane.ERROR_MESSAGE);
			}

			boolean dealersTurn = true;
			while(dealersTurn) {
				if(d.handSum() < 16) {
					dealerHand.add(deck.remove(0));
					if(d.handSum() > 21) {
						JOptionPane.showMessageDialog(null, d.printFullHand() + "\nThe dealer busted!", "Dealer busts!", JOptionPane.INFORMATION_MESSAGE);
						continue gameloop;
					}
					else if(d.handSum() == 21) {
						JOptionPane.showMessageDialog(null, d.printFullHand() + "\nThe dealer got a blackjack! They win", "Dealer wins!", JOptionPane.ERROR_MESSAGE);
						continue gameloop;
					}
				}
				else {
					dealersTurn = false;
				}
			}

			if(p.handSum() == d.handSum()) {
				JOptionPane.showMessageDialog(null,"Your hand:\n" + p.printHand() + p.printSum() + "\n" + printDivider() + "\n" + "Dealer's hand:\n" + d.printFullHand() + d.printSum() + "\n" + printDivider() + "\nYou and the dealer have the same value hand. Nobody wins!", "Nobody won!", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(p.handSum() > d.handSum()) {
				JOptionPane.showMessageDialog(null, "Your hand:\n" + p.printHand() + p.printSum() + "\n" + printDivider() + "\n" + "Dealer's hand:\n" + d.printFullHand() + d.printSum() + "\n" + printDivider() + "\nYour hand has a greater value than the dealer's. You win!", "You won!", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				System.out.println("");
				JOptionPane.showMessageDialog(null, "Your hand:\n" + p.printHand() + p.printSum() + "\n" + printDivider() + "\n" + "Dealer's hand:\n" + d.printFullHand() + d.printSum() + "\n" + printDivider() + "\nThe dealer's hand is higher than yours. You lost!", "You lost!", JOptionPane.ERROR_MESSAGE);
			}

			continue;
			
			}
			catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Ouch!", "Ouch!", JOptionPane.INFORMATION_MESSAGE);
			}

		}

	}
	
	/**
	 * @return A dashed line on the screen
	 */

	static String printDivider() {
		return "--------------------------------";
	}

}
