package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Assets;

public class Skeleton extends Attacker{
	public Skeleton(int[][] map, String team, float x, float y) {
		super(Assets.skeleWalkDown, Assets.skeleWalkUp, Assets.skeleWalkLeft, Assets.skeleWalkRight,
			  Assets.skeleAttackDown, Assets.skeleAttackUp, Assets.skeleAttackLeft, Assets.skeleAttackRight, 
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
