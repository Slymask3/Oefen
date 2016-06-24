package com.abstractlabs.oefen.card;

import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.entity.Attacker;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CardAttacker extends Card {
	private String attacker;
	private float attackerX;
	private float attackerY;
	
	public CardAttacker(TextureRegion texture, Sound sound, float cost, Map map, String team, String attacker) {
		super(Card.ATTACKER, texture, sound, cost, map, team);
		this.attacker = attacker;
		this.map = map;
		this.team = team;
		this.attackerX = team=="Blue"?64+2*32:64+33*32;
		this.attackerY = team=="Blue"?122+13+(map.getBlueStart())*32+10:122+13+(map.getRedStart())*32+10;
	}

	public Attacker createAttacker() {
		return Attacker.createAttacker(attacker, attackerX, attackerY, map, team);
	}
}