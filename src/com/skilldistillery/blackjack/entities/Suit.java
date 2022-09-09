package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String suitName;
	
	Suit(String name){
		this.suitName = name;
	}
	
	@Override
	public String toString() {
		return suitName;
	}

}
