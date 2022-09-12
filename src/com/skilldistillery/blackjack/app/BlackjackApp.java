package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	Scanner kb = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.launch();
	}

	public void launch() {
		while (true) {
			gameStart();
			playerDecision();
			dealerRunnout();
		}
	}

	public void gameStart() {
		System.out.println("Back for more Java Blackjack? Please type play to begin a round or quit to exit.");
		String userInput = kb.nextLine();
		while (true) {
			switch (userInput.toLowerCase()) {

			case ("play"):
				player.getPlayersHand().clear();
				dealer.getPlayersHand().clear();
				dealer.dealFirstRound(player);
				break;

			case ("quit"):
				System.out.println("Have a nice day.");
				System.exit(1);

			default:
				System.out.println("Please enter play or quit. Would you like to play a game?");
				userInput = kb.nextLine();
			}
			break;
		}
	}

	public void playerDecision() {
		if (player.blackjackOrBust()) {
			return;
		}
		
		System.out.println("Please type hit to hit or stay to stay.");
		String userInput = kb.nextLine();
		boolean hitOrStay = true;
		if (player.blackjackOrBust()) {
			hitOrStay = false;
		}
		while (hitOrStay) {
			switch (userInput.toLowerCase()) {

			case ("hit"):
				dealer.dealCard(player);
				System.out.println("Your hand now has a value of: " + player.getHandValue());
				System.out.println();
				if (player.blackjackOrBust()) {
					hitOrStay = false;
					break;
				}
				System.out.println("Please type hit to hit or stay to stay.");
				userInput = kb.nextLine();
				continue;

			case ("stay"):
				hitOrStay = false;
				System.out.println("You chose to stand.");
				System.out.println();
				break;

			default:
				System.out.println("Invalid selection, Please type hit to hit or stay to stay.");
				userInput = kb.nextLine();
			}
			break;
		}
	}

	public void dealerRunnout() {
		boolean hitOrStay = !dealer.blackjackOrBust();
		while (hitOrStay) {
			if (dealer.getHandValue() < 17) {
				System.out.println("Dealer hand is less than 17. Dealer hits.");
				dealer.dealCard(dealer);
				hitOrStay = !dealer.blackjackOrBust();
			} else if (dealer.getHandValue() == player.getHandValue()) {
				System.out.println("You tied the dealer! You get your money back!");
				System.out.println();
				hitOrStay = false;
			} else if (dealer.getHandValue() < 21) {
				System.out.println("Dealer stays. Dealer hand has a value of " + dealer.getHandValue());
				hitOrStay = false;
			} else if (dealer.getHandValue() > 21) {
				hitOrStay = false;
			} else if (dealer.getHandValue() == 21) {
				System.out.println("Dealer has blackjack. You lose.");
				hitOrStay = false;
			}
		}
		winLossLogic();
	}

	public void winLossLogic() {
		if (player.getHandValue() > 21) {
			System.out.println("You lose.");
			System.out.println();
		} else if (dealer.getHandValue() > 21) {
			System.out.println("You win.");
			System.out.println();
		} else if (dealer.getHandValue() > player.getHandValue()) {
			System.out.println("Dealer wins!");
			System.out.println();
//		} else {
//			System.out.println("You win!");
//			System.out.println();
		}
	}
}
