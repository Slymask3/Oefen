package com.abstractlabs.oefen.entity.attacker;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.Spell;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.entity.spell.SpellHeal;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Healer extends AttackerSpell {
	private int heal;
	
	public Healer(ScreenGame screen, Animation walkDown, Animation walkUp, Animation walkLeft, Animation walkRight,
			  Animation spellDown, Animation spellUp, Animation spellLeft, Animation spellRight, 
			  float x, float y, float width, float height, String team, float speed, int hp, int dmg, int range, int attackspeed, int heal) {
		super(screen, walkDown, walkUp, walkLeft, walkRight, spellDown, spellUp, spellLeft, spellRight, 
				x, y, speed, width, height, team, hp, dmg, range, attackspeed);
		this.heal = heal;
//		System.out.println("[Healer] heal=="+this.heal);
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
	
	@Override
	public Spell getSpell() {
		return new SpellHeal(screen, Assets.turtleshell, x, y, 96, 96, team, heal, 48);
	}
	
	//in this case, it finds the target to heal.
	@Override
    public void findTarget() {
    	if(target == null) {
	    	for(int i=0; i<screen.getAttackers().getChildren().size; i++) {
	    		Attacker a = (Attacker)screen.getAttackers().getChildren().get(i);
	    		if(this.team == a.getTeam() && this.rangebox.overlaps(a.getHitboxRectangle()) && a.getHealth() < a.getMaxHealth()) {
	    			this.target = a;
        			this.attacking = true;
        			this.walking = false;
	    		}
	    	}
    	}
    	if(target == null) {
	    	for(int i=0; i<screen.getTowers().getChildren().size; i++) {
	    		Group g = (Group)screen.getTowers().getChildren().get(i);
	    		for(int j=0; j<g.getChildren().size; j++) {
	        		Tower t = (Tower)g.getChildren().get(j);
	        		if(this.team != t.getTeam() && this.rangebox.overlaps(t.getHitboxRectangle()) && t.getHealth() < t.getMaxHealth()) {
	        			this.target = t;
	        			this.attacking = true;
	        			this.walking = false;
	        		}
	        	}
	    	}
    	}
    	
    	if(target != null) {
    		if(target.isDead()) { //if tagrets dead
    			target = null;
    			this.attacking = false;
    			this.walking = true;
    		} else if(!this.rangebox.overlaps(target.getHitboxRectangle())) { //if target leaves the entity's range
    			target = null;
    			this.attacking = false;
    			this.walking = true;
    		} else if(target.getHealth() >= target.getMaxHealth()) { //target is fully healed
    			target = null;
    			this.attacking = false;
    			this.walking = true;
    		}
    	}
    }
}