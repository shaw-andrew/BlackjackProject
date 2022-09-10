package com.skilldistillery.blackjack.entities;

public class Player {

	protected BlackjackHand playersHand = new BlackjackHand();

	public BlackjackHand getPlayersHand() {
		return playersHand;
	}

	public int getHandValue() {
		return playersHand.getHandValue();
	}

//	public void getLastCard() {
//		List<Card> hand = playersHand.getHand();
//		Card lastCard = playersHand.getHand().get(hand.size() - 1);
//		System.out.println(lastCard);
//	}

	public void addCard(Card dealtCard) {
		playersHand.addCard(dealtCard);
	}
	
	@Override
	public String toString() {
		return "User";
	}
	

}
