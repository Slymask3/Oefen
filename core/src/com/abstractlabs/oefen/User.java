package com.abstractlabs.oefen;


public class User {
	private String username;
	private int exp, elo;
	private int[] cards;
	private int gold;
	private String team;
	
	public User(String username, int exp, int elo, int[] cards, String team) {
		this.username = username;
		this.cards = cards;
		this.exp = exp;
		this.elo = elo;
		this.gold = 10000;
		this.team = team;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getElo() {
		return elo;
	}
	
	public int[] getCards() {
		return cards;
	}
	
	public int getGold() {
		return gold;
	}

	public String getTeam() {
		return team;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
}