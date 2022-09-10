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
		gameStart();
		while (true) {
			playerDecision();
			dealerRunnout();
			playAgain();
		}
	}

	public void gameStart() {
		System.out.println("Welcome to Java Blackjack. Would you like to play a game?");
		String userInput = kb.nextLine();
		while (true) {
			switch (userInput.toLowerCase()) {

			case ("yes"):
				dealer.dealFirstRound(player);
				blackjackOrBust(player);
				blackjackOrBust(dealer);

				break;

			case ("no"):
				System.out.println("Have a nice day.");
				System.exit(1);

			default:
				System.out.println("Please enter yes or no. Would you like to play a game?");
				userInput = kb.nextLine();
			}
			break;
		}
	}

	public void playerDecision() {
		System.out.println("Please press 1 to hit or 2 to stand.");
		System.out.println();
		int userInput = kb.nextInt();
		boolean hitOrStay = true;
		while (hitOrStay) {
			switch (userInput) {

			case (1):
				dealer.dealCard(player);
				System.out.println("Your had now has a value of: " + player.getHandValue());
				blackjackOrBust(player);
				System.out.println("Please press 1 to hit or 2 to stand.");
				kb.nextLine();
				userInput = kb.nextInt();
				break;

			case (2):
				hitOrStay = false;
				System.out.println("You chose to stand.");
				System.out.println();
				break;

			default:
				System.out.println("Invalid seleciton, please press 1 to hit or 2 to stand.");
				userInput = kb.nextInt();
			}
			 break;
		}
	}

	public void dealerRunnout() {
		boolean hitOrStay = true;
		while (hitOrStay)
			if (dealer.getHandValue() < 17) {
				dealer.dealCard(dealer);
				blackjackOrBust(dealer);
			}
		if (dealer.getHandValue() < 21) {
			System.out.println("Dealer stays.");
		}

	}

	public void playAgain() {
		System.out.println("Would you like to play again?");
		kb.nextLine();
		String userInput = kb.nextLine();
		
		switch (userInput.toLowerCase()) {
		case ("yes"):
//			player.hand.clear();
//			dealer.hand.clear();
			dealer.dealFirstRound(player);
			kb.nextLine();
			break;
		case ("no"):
			System.out.println("Thanks for playing. Goodbye.");
			System.exit(1);
		default:
			System.out.println("Please enter yes or no. Would you like to play again?");
			userInput = kb.nextLine();
		}
	}

	public void blackjackOrBust(Player player) {
		if (player.getPlayersHand().isBust() || player.getPlayersHand().isBlackjack()) {
			System.out.println("Game over.");
			System.out.println();
			playAgain();

		}
	}
}
