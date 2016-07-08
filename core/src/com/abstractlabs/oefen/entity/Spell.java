package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Cards;
import com.abstractlabs.oefen.Range;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Spell extends Entity {
	protected Animation animation;
    protected float state = 0;

    public Spell(ScreenGame screen, Animation animation, float x, float y, float width, float height, String team, int dmg, int range) {
    	super(screen, null, x, y, width, height, team, 0, dmg, range, 0);
    	this.animation = animation;
    	onSpawn();
    }

    public Spell(ScreenGame screen, TextureRegion texture, float x, float y, float width, float height, String team, int dmg, int range) {
    	super(screen, texture, x, y, width, height, team, 0, dmg, range, 0);
    	this.animation = null;
    	onSpawn();
    }
    
    @Override
    public void draw(Batch batch, float alpha){
    	state += Gdx.graphics.getDeltaTime();
    	
    	if(animation != null) {
            batch.draw(animation.getKeyFrame(state, 1), x-(width/3), y-(height/3), width, height);
    	} else {
    		batch.draw(texture, x-(width/3), y-(height/3), width, height);
    	}
    	
    	if(Settings.showRangebox) {
            Range.drawRectangle(batch, rangebox.x, rangebox.y, rangebox.width, rangebox.height, 1, 0, 0);
        }
		if(Settings.showHitbox) {
			Range.drawRectangle(batch, hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0, 0, 1);
		}
    }
    
    int tick;
    @Override
    public void act(float delta){
    	tick++;
    	if(tick >= 100) {
    		this.remove();
    	}
    }

    public void setXY(float pX,float pY) {
    	this.x = pX;
    	this.y = pY;
        setPosition(pX, pY);
        hitbox.setX((int)pX+((32-width)/2));
        hitbox.setY((int)pY-32);
        rangebox.setX(pX+((32-width)/2)+(width/2)-range);
        rangebox.setY(pY+(height/2)-range-32);
    }
    
    protected void onSpawn() {
    	for(int i=0; i<screen.getAttackers().size(); i++) {
    		if(this.rangebox.overlaps(screen.getAttackers().get(i).hitbox) && this.team != screen.getAttackers().get(i).getTeam()) {
    			screen.getAttackers().get(i).damage(dmg);
    			
    			if(screen.getAttackers().get(i).isDead()) {
    				screen.getAttackers().remove(i);
//    				screen.getAttackers().get(i).remove();
    			}
    		}
    	}
    	for(int i=0; i<screen.getTowers().getChildren().size; i++) {
    		for(int j=0; j<((Group)screen.getTowers().getChildren().get(i)).getChildren().size; j++) {
    			Tower tower = (Tower)((Group)screen.getTowers().getChildren().get(i)).getChildren().get(j);
	    		if(this.rangebox.overlaps(tower.hitbox) && this.team != tower.getTeam()) {
	    			tower.damage(dmg);
	    			if(tower.isDead()) {
	    				tower.remove();
	//    				screen.getTowers().get(i).remove();
	    			}
	    		}
    		}
    	}
    }
    
    //no targets for spells
    @Override
    public void findTarget() {}
    
    ///////////////////////////////////////////////////////////// STATIC CLASS START ///////////////////////////////////////////////////////

//    public static String EXPLOSION = "Explosion";
    
    public static Spell createSpell(ScreenGame screen, Cards spell, float x, float y, String team) {
    	if(spell == Cards.explosion) {
    		return new Spell(screen, Assets.explosion, x, y, 96, 96, team, spell.getDamage(), spell.getRange());
    	} else {
    		return null;
    	}
    }
}