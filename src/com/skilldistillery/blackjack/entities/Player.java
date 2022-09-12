package com.skilldistillery.blackjack.entities;

public class Player {

	protected BlackjackHand playersHand = new BlackjackHand();

	public BlackjackHand getPlayersHand() {
		return playersHand;
	}

	public int getHandValue() {
		return playersHand.getHandValue();
	}

	public void addCard(Card dealtCard) {
		playersHand.addCard(dealtCard);
	}

	public boolean blackjackOrBust() {
		if (playersHand.isBust()) {
			System.out.println(this + " BUSTED with a hand value of " + this.getHandValue());
			System.out.println();
		}

		else if (playersHand.isBlackjack()) {
			System.out.println(this + " got BLACKJACK!");
			System.out.println();
		}

		return (playersHand.isBust() || playersHand.isBlackjack());
	}

	@Override
	public String toString() {
		return "User";
	}

}
