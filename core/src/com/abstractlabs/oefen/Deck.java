package com.abstractlabs.oefen;

import java.util.List;

import com.abstractlabs.oefen.card.Card;

public class Deck {
	private List<Card> cards;
	
	public Deck(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
}