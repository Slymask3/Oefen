package com.abstractlabs.oefen.entity.attacker;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.other.Lazor;
import com.abstractlabs.oefen.screen.ScreenGame;

public class AttackerLazor extends Attacker {
	private float r, g, b;
	
	public AttackerLazor(ScreenGame screen, Animation walkDown, Animation walkUp, Animation walkLeft, Animation walkRight,
			float x, float y, float speed, float width, float height, String team, int hp, int dmg, int range, int attackspeed, float r, float g, float b) {
		super(screen, walkDown, walkUp, walkLeft, walkRight, walkDown, walkUp, walkLeft, walkRight, x, y, speed, width, height, team, hp, dmg, range, attackspeed, Assets.bullet, 0, 0);
		this.r = r;
		this.g = g;
		this.b = b;
		//this.setProjectileTexture(Assets.heatOrb);
		//System.out.println("projectile: "+projectile);
	}

	@Override
	public Lazor getProjectile() {
		//System.out.println("getProjectile() in attackerlazor called");
    	return new Lazor(screen, getX()+(getWidth()/2), y+(height/2), target.getX()+(target.getWidth()/2), target.getY()+(target.getHeight()/2), r, g, b);
    }
}