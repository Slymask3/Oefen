package com.abstractlabs.oefen.entity.attacker;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.Spell;
import com.abstractlabs.oefen.screen.ScreenGame;

public abstract class AttackerSpell extends Attacker {
	public AttackerSpell(ScreenGame screen, Animation walkDown,
			Animation walkUp, Animation walkLeft, Animation walkRight,
			Animation attackDown, Animation attackUp, Animation attackLeft,
			Animation attackRight, float x, float y, float speed, float width,
			float height, String team, int hp, int dmg, int range,
			int attackspeed) {
		super(screen, walkDown, walkUp, walkLeft, walkRight, attackDown, attackUp,
				attackLeft, attackRight, x, y, speed, width, height, team, hp, dmg,
				range, attackspeed);
	}

	public void actAttacking() {
		if(attacking) {
        	if(dir==0) { //right
        		this.texture = attackRight;
        	} else if(dir==1) { //left
        		this.texture = attackLeft;
        	} else if(dir==2) { //up
        		this.texture = attackUp;
        	} else if(dir==3) { //down
        		this.texture = attackDown;
        	}
        	
        	tick++;
        	if(tick >= attackspeed) {
    			Spell spell = getSpell();
        		this.getStage().addActor(spell);
        		tick = 0;
        	}
        }
	}
	
	public abstract Spell getSpell();
}