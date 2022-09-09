package com.skilldistillery.blackjack.entities;

public enum Rank {
	TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), 
	EIGHT(7), NINE(8), TEN(9), JACK(10), QUEEN(10), KING(10), 
	ACE(11);

	private int value;
	
	Rank(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
