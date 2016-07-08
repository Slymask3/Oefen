package com.abstractlabs.oefen.entity.spell;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.entity.Spell;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.scenes.scene2d.Group;

public class SpellHeal extends Spell {
	public SpellHeal(ScreenGame screen, Animation animation, float x, float y, float width, float height, String team, int heal, int range) {
		super(screen, animation, x, y, width, height, team, heal, range);
//		System.out.println("[SpellHeal] heal=="+this.dmg);
	}
	
	@Override
	protected void onSpawn() {
    	for(int i=0; i<screen.getAttackers().size(); i++) {
    		if(this.rangebox.overlaps(screen.getAttackers().get(i).getHitboxRectangle()) && this.team == screen.getAttackers().get(i).getTeam() && screen.getAttackers().get(i).getHealth() < screen.getAttackers().get(i).getMaxHealth()) {
    			screen.getAttackers().get(i).heal(dmg);
    			//System.out.println("[onSpawn-Tower] heal=="+this.dmg);
    		}
    	}
    	for(int i=0; i<screen.getTowers().getChildren().size; i++) {
    		for(int j=0; j<((Group)screen.getTowers().getChildren().get(i)).getChildren().size; j++) {
    			Tower tower = (Tower)((Group)screen.getTowers().getChildren().get(i)).getChildren().get(j);
	    		if(this.rangebox.overlaps(tower.getHitboxRectangle()) && this.team == tower.getTeam() && tower.getHealth() < tower.getMaxHealth()) {
	    			tower.heal(dmg);
//	    			System.out.println("[onSpawn-Tower] heal=="+this.dmg);
	    		}
    		}
    	}
    }
}