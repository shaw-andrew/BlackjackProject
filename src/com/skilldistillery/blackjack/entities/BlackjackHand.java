package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			System.out.println();
			System.out.println("BLACKJACK!");
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println();
			System.out.println("Busted.");
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

}
