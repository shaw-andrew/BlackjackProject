package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardDeck = new ArrayList<>();

	public Deck() {
		cardDeck = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cardDeck.size();
	}

	public Card dealCard() {
		return cardDeck.remove(0);
	}

	public void dealCard(Hand hand) {
		hand.addCard(cardDeck.remove(0));
	}

	public void shuffle() {
		Collections.shuffle(cardDeck);
	}

}