package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.entity.other.Death;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {
	protected ScreenGame screen;
	protected TextureRegion texture;
    protected float x;
	protected float y;
	protected float width;
	protected float height;
	protected int[][] map = new int[17][36];
	protected float xc;
	protected float yc;
	protected String team;
	protected Rectangle hitbox;
	protected Rectangle rangebox;
	protected int range;
	protected int hp;
	protected int dmg;
	protected int maxhp;
	protected Map mapObj;
    protected int attackspeed;

	public Entity(ScreenGame screen, TextureRegion texture, float x, float y, float width, float height, String team, int hp, int dmg, int range, int attackspeed) {
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
    	this.mapObj = screen.getMap();
    	this.attackspeed = attackspeed;
    	this.screen = screen;
    	
    	this.hitbox = new Rectangle(x+((32-width)/2)+(width/2), y+(height/2), width, height);
    	this.rangebox = new Rectangle((x+((32-width)/2)+(width/2))-range, (y+(height/2))-range, range*2, range*2);
    	
    	this.setXY(x, y);
    	
    	int xp = 0;
    	int yp = mapObj.getPath().length-1;
    	for(int i=0; i<mapObj.getPath().length; i++) {
	    	for(int k=0; k<mapObj.getPath()[i].length; k++) {
	    		this.map[i][k] = mapObj.getPath()[yp][xp];
	    		xp++;
	    	}
    		yp--;
    		xp=0;
    	}
    }
	
	public Entity(ScreenGame screen, TextureRegion texture, float x, float y, float width, float height) {
		this(screen, texture, x, y, width, height, null, 0, 0, 0, 0);
    }
	
	public Entity(ScreenGame screen, float x, float y, float width, float height) {
		this(screen, null, x, y, width, height, null, 0, 0, 0, 0);
    }
	
	public Entity(ScreenGame screen, float x, float y) {
		this(screen, null, x, y, 0, 0, null, 0, 0, 0, 0);
    }
    
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture, x, y, width, height);
    }
    
    public ScreenGame getScreen() {
    	return this.screen;
    }
    
    public float getX() {
    	return this.x;
    }
    
    public float getY() {
    	return this.y;
    }
    
    public float getWidth() {
    	return this.width;
    }
    
    public float getHeight() {
    	return this.height;
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
        hitbox.setX((int)pX+((32-width)/2));
        hitbox.setY((int)pY);
        rangebox.setX(pX+((32-width)/2)+(width/2)-range);
        rangebox.setY(pY+(height/2)-range);
    }
    
    public void damage(int amount) {
    	this.hp -= amount;
    }
    
    public boolean isDead() {
    	return hp<=0?true:false;
    }
    
    protected Animation deathAnimation = Assets.blood;
    protected float deathR = 1, deathG = 0, deathB = 0;
    
    public Death getDeath() {
    	return new Death(screen, deathAnimation, x, y, deathR, deathG, deathB);
    }
    
    public void setDeath(Animation animation, float r, float g, float b) {
    	this.deathAnimation = animation;
    	this.deathR = r;
    	this.deathG = g;
    	this.deathB = b;
    }
    
    public void setHealth(int hp) {
    	this.hp = hp;
    }
    
    public void setMaxHealth(int hp) {
    	this.hp = hp;
    	this.maxhp = hp;
    }
    
    public void setDamage(int dmg) {
    	this.dmg = dmg;
    }
    
    public void setRange(int range) {
    	this.range = range;
    }
    
    public void setAttackSpeed(int speed) {
    	this.attackspeed = speed;
    }
}