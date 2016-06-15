package com.abstractlabs.oefen.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {
	TextureRegion texture;
    float x, y, width, height;
    int[][] map = new int[17][36];
	float xc;
	float yc;
	String team;
	Rectangle hitbox;
	Rectangle rangebox;
	int range;
	int hp;
	int dmg;
	int maxhp;

    public Entity(TextureRegion texture, float x, float y, float width, float height, int[][] map, String team, int hp, int dmg, int range) {
    	this.texture = texture;
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	this.xc = x;
    	this.yc = y;
    	this.team = team;
    	this.hp = hp;
    	this.dmg = dmg;
    	this.maxhp = hp;
    	this.range = range;

    	this.hitbox = new Rectangle(x+(width/4), y, width/2, height/2);
    	this.rangebox = new Rectangle((x+(width/2))-range, (y+(height/2))-range, range*2, range*2);
    	
    	int xp = 0;
    	int yp = map.length-1;
    	for(int i=0; i<map.length; i++) {
	    	for(int k=0; k<map[i].length; k++) {
	    		this.map[i][k] = map[yp][xp];
	    		xp++;
	    	}
    		yp--;
    		xp=0;
    	}
    }
    
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture, x, y, width, height);
    }
    
    public String getTeam() {
    	return this.team;
    }
    
    public Rectangle getHitboxRectangle() {
        return hitbox;
    }
    
    public Rectangle getRangeRectangle() {
        return rangebox;
    }

    public void setXY(float pX,float pY) {
    	this.x = pX;
    	this.y = pY;
        setPosition(pX, pY);
        hitbox.setX((int)pX+(width/4));
        hitbox.setY((int)pY);
        rangebox.setX(pX+(width/2)-range);
        rangebox.setY(pY+(height/2)-range);
    }
    
    public void damage(int amount) {
    	this.hp -= amount;
    }
    
    public boolean isDead() {
    	return hp<=0?true:false;
    }
}