package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Cards;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.Range;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.entity.other.Projectile;
import com.abstractlabs.oefen.entity.other.TempText;
import com.abstractlabs.oefen.entity.tower.BuddhaGold;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tower extends Entity {
    public boolean attacking = false;
	Entity target;
	protected TextureRegion projectile;
	protected float pw, ph;
	protected int mapX, mapY;
	protected Animation animation;
    protected float state = 0;

    public Tower(ScreenGame screen, Animation texture, float x, float y, float width, float height, String team, int hp, int dmg, int range, int attackspeed) {
    	super(screen, null, x, y, width, height, team, hp, dmg, range, attackspeed);
    	this.target = null;
    	this.animation = texture;
    }

    public Tower(ScreenGame screen, TextureRegion texture, float x, float y, float width, float height, String team, int hp, int dmg, int range, int attackspeed) {
    	super(screen, texture, x, y, width, height, team, hp, dmg, range, attackspeed);
    	this.target = null;
    	this.animation = null;
    }

    public Tower(ScreenGame screen) {
    	super(screen, null, 0, 0, 0, 0, "No", 0, 0, 0, 0);
    }

    public Tower(ScreenGame screen, TextureRegion texture, float x, float y, float width, float height, String team, int hp, int dmg, int range, int attackspeed, TextureRegion projectile, float pw, float ph) {
    	super(screen, texture, x, y, width, height, team, hp, dmg, range, attackspeed);
    	this.target = null;
    	this.projectile = projectile;
    	this.pw = pw;
    	this.ph = ph;
    }
    BitmapFont font = Font.create(Font.sufrimeda, 30);
    @Override
    public void draw(Batch batch, float alpha){
    	state += Gdx.graphics.getDeltaTime();
    	
    	if(this.team == "Blue") {
    		batch.setColor(0.8f, 0.8f, 1, 1);
    	} else {
    		batch.setColor(1, 0.8f, 0.8f, 1);
    	}
    	if(animation != null) {
            batch.draw(animation.getKeyFrame(state, 0), x, y, width, height);
    	} else {
    		batch.draw(texture, x, y, width, height);
    	}
        batch.setColor(1, 1, 1, 1);
        
        batch.setColor(1, 0, 0, 1);
        batch.draw(Assets.hpbar, x, y+height);
        batch.setColor(0, 1, 0, 1);
        double php = (double)hp/maxhp;
        batch.draw(Assets.hpbar, x, y+height, Math.round(php*32), 4);
        batch.setColor(1, 1, 1, 1);
        
        if(Settings.showRangebox) {
            Range.drawRectangle(batch, rangebox.x, rangebox.y, rangebox.width, rangebox.height, 1, 0, 0);
        }
		if(Settings.showHitbox) {
			Range.drawRectangle(batch, hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0, 0, 1);
		}
		
		//font.draw(batch, this.getZIndex()+"", x+16, y+16);
    }
    
    int tick;
    @Override
    public void act(float delta){
        if(attacking) {
        	tick++;
        	if(tick >= 100 && target != null) {
        		Projectile arrow = new Projectile(screen, projectile, pw, ph, x+(width/2), y+(height/2), target.x+(target.width/2), target.y+(target.height/2));
        		this.getStage().addActor(arrow);
        		
        		tick = 0;
        		target.damage(dmg);
        		if(target.isDead()) {
        			attacking = false;
        			target = null;
        		}
        	}
        }
        
        if(isDead()) {
        	this.remove();
        }
    }
    
    public void setAttacking(boolean bool) {
    	this.attacking = bool;
    }
    
    @Override
    public void damage(int amount) {
    	this.hp -= amount;
    	TempText temp = new TempText(screen, "-"+amount, x, y, 1f, 0f, 0f);
    	if(!this.isDead()) {
        	screen.getStage().addActor(temp);
    	}
    	if(hp <= 0) {
    		attacking = false;
    	}
    }
    
    public void setTarget(Entity target) {
    	this.target = target;
    }

	public void setMapPos(int mapY, int mapX) {
		this.mapX = mapX;
		this.mapY = mapY;
	}
	
	public int getMapX() {
		return this.mapX;
	}
	
	public int getMapY() {
		return this.mapY;
	}
	
	public void setZIndexBy(int i) {
		this.setZIndex(screen.getTowers().getChildren().size+i);
	}
	
	public int getZOrder() {
		return this.mapY+(this.mapX*17);
	}
    
    ///////////////////////////////////////////////////////////// STATIC CLASS START ///////////////////////////////////////////////////////

//    public static String WTFISTHIS = "wtf";
//    public static String BUDDHAGOLD = "BuddhaGold";
//    public static String DUMMY = "Dummy";
    
    public static Tower createTower(ScreenGame screen, Cards tower, float x, float y, String team) {
    	if(tower == Cards.wtfisthis) {
    		return new Tower(screen, Assets.wtfisthis, x, y, 32, 32, team, tower.getHealth(), tower.getDamage(), tower.getRange(), tower.getAttackSpeed(), Assets.bullet, 5, 5);
    	} else if(tower == Cards.buddhaGold) {
    		return new BuddhaGold(screen, team, x, y, tower.getHealth(), tower.getDamage(), tower.getRange(), tower.getCustom(), tower.getAttackSpeed());
    	} else if(tower == Cards.dummy) {
    		Tower t = new Tower(screen, Assets.dummySpin, x, y, 32, 32, team, tower.getHealth(), tower.getDamage(), tower.getRange(), tower.getAttackSpeed());
    		t.setDeath(Assets.dummyDeath, 1, 1, 1);
    		return t;
    	} else if(tower == Cards.lazorRed) {
    		return new Tower(screen, Assets.lazorRed, x, y, 32, 64, team, tower.getHealth(), tower.getDamage(), tower.getRange(), tower.getAttackSpeed(), Assets.heatOrb, 5, 5);
    	} else {
    		return null;
    	}
    }
}