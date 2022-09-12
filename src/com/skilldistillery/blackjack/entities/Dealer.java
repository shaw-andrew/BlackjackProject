package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck = new Deck();

	public void shuffle() {
		deck.shuffle();
	}

	public Card dealCard(Player player) {
		Card card = deck.dealCard();
		player.addCard(card);
		System.out.println(player + " was dealt a " + card + ".");
		return card;
	}

	public Card dealCardFaceDown(Player player) {
		Card card = deck.dealCard();
		player.addCard(card);
		System.out.println(player + " dealt themself a card face down.");
		return card;
	}

	public void dealFirstRound(Player player) {
		shuffle();
		System.out.println("Dealer grabs a freshly shuffled deck and begins to deal.");
		Card card = dealCard(player);
		card = dealCardFaceDown(this);
		card = dealCard(player);
		card = dealCard(this);
		System.out.println();
		System.out.println("Your hand has a value of " + player.playersHand.getHandValue() + " against the " + card
				+ " showing for the dealer.");
		System.out.println();
	}

	@Override
	public String toString() {
		return "Dealer";
	}

}
