package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Assets;

public class Goblin extends Attacker {
	public Goblin(int[][] map, String team, float x, float y) {
		super(Assets.goblinWalkDown, Assets.goblinWalkUp, Assets.goblinWalkLeft, Assets.goblinWalkRight,
			  Assets.goblinAttackDown, Assets.goblinAttackUp, Assets.goblinAttackLeft, Assets.goblinAttackRight, 
			  x, y, 
			  1f, //speed
			  32, //width
			  32, //height
			  map, team, 
			  30, //health
			  7, //damage
			  16); //range
	}
}