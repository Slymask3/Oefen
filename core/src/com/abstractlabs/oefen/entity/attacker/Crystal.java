package com.abstractlabs.oefen.entity.attacker;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.other.Lightning;
import com.abstractlabs.oefen.screen.ScreenGame;

public class Crystal extends Attacker {
	public Crystal(ScreenGame screen, Animation animation, float x, float y, float speed, float width, float height, String team, int hp, int dmg, int range, int attackspeed) {
		super(screen, animation, x, y, speed, width, height, team, hp, dmg, range, attackspeed, Assets.bullet, 0, 0);
	}

	@Override
	public Lightning getProjectile() {
		//System.out.println("getProjectile() in crystal called");
    	return new Lightning(screen, getX()+(getWidth()/2), y+(height/2), target.getX()+(target.getWidth()/2), target.getY()+(target.getHeight()/2));
    }
}