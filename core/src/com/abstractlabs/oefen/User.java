package com.abstractlabs.oefen;


public class User {
	private String username;
	private int exp, elo;
	private int[] cards;
	
	public User(String username, int exp, int elo, int[] cards) {
		this.username = username;
		this.cards = cards;
		this.exp = exp;
		this.elo = elo;
	}
	
//	public User(String username) {
//		this.username = username;
//		
//		Random rand = new Random();
//		List<Card> cards = new ArrayList<Card>();
//		for(int i=0; i<30; i++) {
//		  	int r = rand.nextInt(Cards.all.size());
//		  	String team = rand.nextInt(2)==0?"Blue":"Red";
//			if(Cards.all.get(r).getType() == "Attacker") {
//			      cards.add(new CardAttacker(Cards.all.get(r), Assets.clickSound, team));
//			} else if(Cards.all.get(r).getType() == "Tower") {
//			      cards.add(new CardTower(Cards.all.get(r), Assets.clickSound, team));
//			} else if(Cards.all.get(r).getType() == "Spell") {
//		          cards.add(new CardSpell(Cards.all.get(r), Assets.clickSound, team));
//		  	}
//		}
//		cards = new Deck(cards);
//	}
//	
//	public User() {
//		this.username = DB.getRandomName(new RestDBClient());
//		
//		Random rand = new Random();
//		List<Card> cards = new ArrayList<Card>();
//		for(int i=0; i<30; i++) {
//		  	int r = rand.nextInt(Cards.all.size());
//		  	String team = rand.nextInt(2)==0?"Blue":"Red";
//			if(Cards.all.get(r).getType() == "Attacker") {
//			      cards.add(new CardAttacker(Cards.all.get(r), Assets.clickSound, team));
//			} else if(Cards.all.get(r).getType() == "Tower") {
//			      cards.add(new CardTower(Cards.all.get(r), Assets.clickSound, team));
//			} else if(Cards.all.get(r).getType() == "Spell") {
//		          cards.add(new CardSpell(Cards.all.get(r), Assets.clickSound, team));
//		  	}
//		}
//		deck = new Deck(cards);
//	}
	
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
}