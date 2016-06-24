package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.entity.other.Arrow;
import com.abstractlabs.oefen.entity.other.TempText;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Tower extends Entity {
    public boolean attacking = false;
	Entity target;

    public Tower(TextureRegion texture, float x, float y, float width, float height, Map map, String team, int hp, int dmg, int range) {
    	super(texture, x, y, width, height, map, team, hp, dmg, range);
    	this.target = null;
    }
    
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture, x, y, width, height);
        
        batch.setColor(1, 0, 0, 1);
        batch.draw(Assets.hpbar, x, y+32);
        batch.setColor(0, 1, 0, 1);
        double php = (double)hp/maxhp;
        batch.draw(Assets.hpbar, x, y+32, Math.round(php*32), 4);
        batch.setColor(1, 1, 1, 1);
    }
    
    int tick;
    @Override
    public void act(float delta){
        if(attacking) {
        	tick++;
        	if(tick >= 100 && target != null) {
        		Arrow arrow = new Arrow(15, 3, x+(width/2), y+(height/2), target.x+(target.width/2), target.y+(target.height/2), mapObj);
        		this.getStage().addActor(arrow);
        		
        		tick = 0;
        		target.damage(dmg);
        		if(target.isDead()) {
        			attacking = false;
        			target = null;
        		}
        	}
        }
    }
    
    public void setAttacking(boolean bool) {
    	this.attacking = bool;
    }
    
    @Override
    public void damage(int amount) {
    	this.hp -= amount;
    	TempText temp = new TempText("-"+amount, x, y, 1f, 0f, 0f, mapObj);
    	if(!this.isDead()) {
        	this.getParent().addActor(temp);
    	}
    	if(hp <= 0) {
    		attacking = false;
    	}
    }
    
    public void setTarget(Entity target) {
    	this.target = target;
    }
}