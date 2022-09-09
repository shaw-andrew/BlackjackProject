package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingApp {

	public static void main(String[] args) {
		DealingApp da = new DealingApp();
		da.playGame();
	}
	
	public void playGame() {
		dealEm();
	}
	
	public void dealEm() {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("how many? ");
		
		int numCardsToDeal = sc.nextInt();
		int total = 0;
		
		int numCardsDealt = 0;
		while(numCardsDealt < numCardsToDeal  ) {
			Card card = deck.dealCard();
			System.out.print("Dealt " + card + " => ");
			System.out.println(deck.checkDeckSize() + " cards left");
			total += card.getValue();
			numCardsDealt++;
		}
		System.out.println();
		System.out.println("your total hand " + total);
	}

}