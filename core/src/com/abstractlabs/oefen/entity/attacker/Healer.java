package com.abstractlabs.oefen.entity.attacker;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.screen.ScreenGame;

public class Healer extends Attacker {
	private int heal;
	private boolean healing;
	
	public Healer(ScreenGame screen, Animation walkDown, Animation walkUp, Animation walkLeft, Animation walkRight,
			  Animation spellDown, Animation spellUp, Animation spellLeft, Animation spellRight, 
			  float x, float y, float width, float height, String team, float speed, int hp, int dmg, int range, int attackspeed, int heal) {
		super(screen, walkDown, walkUp, walkLeft, walkRight, spellDown, spellUp, spellLeft, spellRight, 
				x, y, speed, width, height, team, hp, dmg, range, attackspeed);
		this.heal = heal;
	}
	
	@Override
    public void act(float delta){
        actWalking();
        actAttacking();
        actHealing();
        removeIfDead();
    }
    
    protected void actHealing() {
    	for(int i=0; i<screen.getAttackers().size(); i++) {
    		Attacker a = screen.getAttackers().get(i);
    		if(a.getTeam() == this.getTeam() && a.getHealth() < a.getMaxHealth()) {
    			this.healing = true;
    		}
    	}
    	
    	if(healing) {
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
        	if(tick >= 100 && target != null) {
        		tick = 0;
        		
        		for(int i=0; i<screen.getAttackers().size(); i++) {
            		Attacker a = screen.getAttackers().get(i);
            		if(a.getTeam() == this.getTeam() && a.getHealth() < a.getMaxHealth()) {
                		a.heal(heal);
            		}
            	}
        		healing = false;
        		walking = true;
        	}
        }
    }
    
//    @Override
//    public void setAttacking(boolean attacking) {
//    	this.attacking = false; //make sure attacking is always off
//    }
    
}