package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand.removeAll(hand);
	}
	
	public abstract int getHandValue();
	
	

	public List<Card> getHand() {
		return hand;
	}

	@Override
	public String toString() {
		return "This hand has a value of " + getHandValue();
	}

	
	
}
