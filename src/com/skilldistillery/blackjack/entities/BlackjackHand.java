package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		if (handValue > 21) {
			for (Card card : hand) {
				if (card.getRank() == Rank.ACE) {
					handValue -= 10;
//					System.out.println("Time for that soft ace, baby.");
				}
			}
		}
		return handValue;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

}
