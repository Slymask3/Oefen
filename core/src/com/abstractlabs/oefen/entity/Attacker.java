package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Cards;
import com.abstractlabs.oefen.Range;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.entity.attacker.Crystal;
import com.abstractlabs.oefen.entity.other.Projectile;
import com.abstractlabs.oefen.entity.other.TempText;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Attacker extends Entity {
	protected Animation texture;
	protected float speed;
    protected boolean walking = false;
    protected boolean attacking = false;
    protected float state = 0;
    protected int dir;
	protected Entity target;
	protected Animation walkDown, walkUp, walkLeft, walkRight, attackDown, attackUp, attackLeft, attackRight;
    protected int tick;
    protected TextureRegion projectile;
    protected int pw, ph;

    public Attacker(ScreenGame screen, Animation walkDown, Animation walkUp, Animation walkLeft, Animation walkRight, 
    				Animation attackDown, Animation attackUp, Animation attackLeft, Animation attackRight, 
    				float x, float y, float speed, float width, float height, String team, int hp, int dmg, int range, int attackspeed) {
    	super(screen, walkDown.getKeyFrame(0, 0), x, y, width, height, team, hp, dmg, range, attackspeed);
    	this.texture = walkDown;
    	this.speed = speed;
    	this.dir = team=="Blue"?0:1;
    	this.target = null;
    	this.walkDown = walkDown;
    	this.walkUp = walkUp;
    	this.walkLeft = walkLeft;
    	this.walkRight = walkRight;
    	this.attackDown = attackDown;
    	this.attackUp = attackUp;
    	this.attackLeft = attackLeft;
    	this.attackRight = attackRight;
    }
    
    public Attacker(ScreenGame screen, Animation walkDown, Animation walkUp, Animation walkLeft, Animation walkRight, 
			Animation attackDown, Animation attackUp, Animation attackLeft, Animation attackRight, 
			float x, float y, float speed, float width, float height, String team, int hp, int dmg, int range, int attackspeed,
			TextureRegion projectile, int pw, int ph) {
    	this(screen, walkDown, walkUp, walkLeft, walkRight, attackDown, attackUp, attackLeft, attackRight, x, y, speed, width, height, team, hp, dmg, range, attackspeed);
		this.projectile = projectile;
		this.pw = pw;
		this.ph = ph;
	}
    
    public Attacker(ScreenGame screen, Animation animation, 
			float x, float y, float speed, float width, float height, String team, int hp, int dmg, int range, int attackspeed,
			TextureRegion projectile, int pw, int ph) {
    	this(screen, animation, animation, animation, animation, animation, animation, animation, animation, x, y, speed, width, height, team, hp, dmg, range, attackspeed);
		this.projectile = projectile;
		this.pw = pw;
		this.ph = ph;
	}
    
    public Attacker(ScreenGame screen, Animation animation, 
			float x, float y, float speed, float width, float height, String team, int hp, int dmg, int range, int attackspeed) {
    	this(screen, animation, animation, animation, animation, animation, animation, animation, animation, x, y, speed, width, height, team, hp, dmg, range, attackspeed);
	}
    
    @Override
    public void draw(Batch batch, float alpha){
    	state += Gdx.graphics.getDeltaTime();
    	
    	if(this.team == "Blue") {
    		batch.setColor(0.8f, 0.8f, 1, 1);
    	} else {
    		batch.setColor(1, 0.8f, 0.8f, 1);
    	}
        batch.draw(texture.getKeyFrame(state, 0), x+((32-width)/2), y, width, height);
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
    }
    
    @Override
    public void act(float delta){
        if(walking){
        	int xcoord = (int) (((xc)-64)/32);
        	int ycoord = (int) (((yc)-122-13)/32);
//        	int xcoord = Math.round(((x)-64)/32);
//        	int ycoord = Math.round(((y)-122)/32);
//        	System.out.println("["+this.toString()+"] x="+x+" | y="+y+" | xc="+xcoord+" | yc="+ycoord+" | tile="+map[ycoord][xcoord]);
//        	if(isPath(map[ycoord][xcoord+1])) {
//                texture = walkRight;
//                x+=speed;
//                System.out.println("Walking Right");
//        	} else if(isPath(map[ycoord][xcoord-1])) {
//                texture = walkLeft;
//                x-=speed;
//                System.out.println("Walking Left");
//        	}
//        	
//        	if(isPath(map[ycoord+1][xcoord])) {
//                texture = walkUp;
//                y+=speed;
//                System.out.println("Walking Up");
//        	} else if(isPath(map[ycoord-1][xcoord])) {
//                texture = walkDown;
//                y-=speed;
//                System.out.println("Walking Down");
//        	}
        	
        	if(team == "Blue") {
	        	if(map[ycoord][xcoord] == 2) {
	//                y+=speed;
	                dir = 2;
	                //System.out.println("Walking Up");
	        	} else if(map[ycoord][xcoord] == 3) {
	//                x+=speed;
	                dir = 0;
	                //System.out.println("Walking Right");
	        	} else if(map[ycoord][xcoord] == 4) {
	//                y-=speed;
	                dir = 3;
	                //System.out.println("Walking Down");
	        	} else if(map[ycoord][xcoord] == 5) {
	//                x+=speed;
	                dir = 0;
	                //System.out.println("Walking Right");
	        	} else if(map[ycoord][xcoord] == 0 || map[ycoord][xcoord] == 20) {
	        		dir = -1;
	                //System.out.println("Stopped");
	        	}
	        	
	        	if(dir==0) { //right
	        		//x+=speed;
	        		setXY(x+=speed, y);
	        		xc = x;
	        		yc = y;
	                texture = walkRight;
	        	} else if(dir==1) { //left
	        		//x-=speed;
	        		setXY(x-=speed, y);
	        		xc = x+16;
	        		yc = y+16;
	                texture = walkLeft;
	        	} else if(dir==2) { //up
	        		//y+=speed;
	        		setXY(x, y+=speed);
	        		xc = x;
	        		yc = y-10;
	                texture = walkUp;
	        	} else if(dir==3) { //down
	        		//y-=speed;
	        		setXY(x, y-=speed);
	        		xc = x+16;
	        		yc = y+16;
	                texture = walkDown;
	        	}
        	} else if(team == "Red") {
	        	if(map[ycoord][xcoord] == 2) {
	                dir = 1;
	        	} else if(map[ycoord][xcoord] == 3) {
	                dir = 3;
	        	} else if(map[ycoord][xcoord] == 4) {
	                dir = 1;
	        	} else if(map[ycoord][xcoord] == 5) {
	                dir = 2;
	        	} else if(map[ycoord][xcoord] == 0 || map[ycoord][xcoord] == 20) {
	        		dir = -1;
	        	}
	        	
	        	if(dir==0) { //right
	        		//x+=speed;
	        		setXY(x+=speed, y);
	        		xc = x;
	        		yc = y;
	                texture = walkRight;
	        	} else if(dir==1) { //left
	        		//x-=speed;
	        		setXY(x-=speed, y);
	        		xc = x+30;
	        		yc = y+16;
	                texture = walkLeft;
	        	} else if(dir==2) { //up
	        		//y+=speed;
	        		setXY(x, y+=speed);
	        		xc = x;
	        		yc = y-10;
	                texture = walkUp;
	        	} else if(dir==3) { //down
	        		//y-=speed;
	        		setXY(x, y-=speed);
	        		xc = x+16;
	        		yc = y+16;
	                texture = walkDown;
	        	}
        	}
        }
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
        	//System.out.println(tick);
        	if(tick >= 100 && target != null) {
        		
        		if(projectile != null) {
        			//System.out.println("requesting projectile");
        			Projectile arrow = getProjectile();
            		this.getStage().addActor(arrow);
        		}
        		
        		tick = 0;
        		target.damage(dmg);
        		if(target.isDead()) {
        			attacking = false;
        			walking = true;
        			target = null;
        		}
        	}
        }
        
        if(isDead()) {
        	this.remove();
        }
    }
    
//    private boolean isPath(int tile) {
//    	return tile==1||tile==2||tile==3||tile==4||tile==5||tile==6||tile==10;
//    }
    
    public void setWalking(boolean bool) {
    	this.walking = bool;
    }
    
    public void setAttacking(boolean bool) {
    	this.attacking = bool;
    }
    
    @Override
    public void damage(int amount) {
    	this.hp -= amount;
    	TempText temp = new TempText(screen, "-"+amount, x, y, 1f, 0f, 0f);
    	if(this.getParent() != null) {
        	this.getParent().addActor(temp);
    	}
    	if(hp <= 0) {
    		attacking = false;
    		walking = false;
    	}
    	//System.out.println("["+team+"] hp="+hp+" | maxhp="+maxhp+" | dmg by="+amount);
    }
    
    public void setTarget(Entity target) {
    	this.target = target;
    }
    
    public Projectile getProjectile() {
		//System.out.println("getProjectile() in attacker called");
    	return new Projectile(screen, projectile, pw, ph, getX()+(getWidth()/2), y+(height/4), target.getX()+(target.getWidth()/2), target.getY()+(target.getHeight()/2));
    }
    
    public void setMoveSpeed(float speed) {
    	this.speed = speed;
    }
    
    ///////////////////////////////////////////////////////////// STATIC CLASS START ///////////////////////////////////////////////////////

//    public static String GOBLIN = "Goblin";
//    public static String FAIRY = "Fairy";
//    public static String GOBLINDARKMAGE = "Dark Mage Goblin";
//    public static String SPIDERRED = "SpiderRed";
//    public static String CRYSTALBLUE = "CrystalBlue";
//    public static String KNIGHT = "Knight";
//    public static String BAT = "Bat";
//    public static String GOLEM = "Golem";
//    public static String MAGE = "Mage";
    
    public static Attacker createAttacker(ScreenGame screen, Cards attacker, float x, float y, String team) {
    	if(attacker == Cards.goblin) {
    		return new Attacker(screen, Assets.goblinWalkDown, Assets.goblinWalkUp, Assets.goblinWalkLeft, Assets.goblinWalkRight,
    				  Assets.goblinAttackDown, Assets.goblinAttackUp, Assets.goblinAttackLeft, Assets.goblinAttackRight, 
    				  x, y, attacker.getMoveSpeed(), 32, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
    	} else if(attacker == Cards.fairy) {
    		return new Attacker(screen, Assets.fairyWalkDown, Assets.fairyWalkUp, Assets.fairyWalkLeft, Assets.fairyWalkRight,
  				  Assets.fairyWalkDown, Assets.fairyWalkUp, Assets.fairyWalkLeft, Assets.fairyWalkRight, 
				  x, y, attacker.getMoveSpeed(), 24, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
    	} else if(attacker == Cards.goblinDarkMage) {
    		return new Attacker(screen, Assets.goblinDarkMageWalkDown, Assets.goblinDarkMageWalkUp, Assets.goblinDarkMageWalkLeft, Assets.goblinDarkMageWalkRight,
    				  Assets.goblinDarkMageAttackDown, Assets.goblinDarkMageAttackUp, Assets.goblinDarkMageAttackLeft, Assets.goblinDarkMageAttackRight, 
    				  x, y, attacker.getMoveSpeed(), 32, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed(),
    				  Assets.fireball, 16, 16);
      	} else if(attacker == Cards.spiderRed) {
    		return new Attacker(screen, Assets.spiderRedWalkDown, Assets.spiderRedWalkUp, Assets.spiderRedWalkLeft, Assets.spiderRedWalkRight,
  				  Assets.spiderRedAttackDown, Assets.spiderRedAttackUp, Assets.spiderRedAttackLeft, Assets.spiderRedAttackRight, 
				  x, y, attacker.getMoveSpeed(), 32, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
    	} else if(attacker == Cards.crystalBlue) {
    		return new Crystal(screen, Assets.crystalBlueSpin,
  				  x, y, attacker.getMoveSpeed(), 32, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
    	} else if(attacker == Cards.knight) {
    		return new Attacker(screen, Assets.knightWalkDown, Assets.knightWalkUp, Assets.knightWalkLeft, Assets.knightWalkRight,
    				  Assets.knightAttackDown, Assets.knightAttackUp, Assets.knightAttackLeft, Assets.knightAttackRight, 
    				  x, y, attacker.getMoveSpeed(), 32, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
      	} else if(attacker == Cards.bat) {
    		return new Attacker(screen, Assets.batWalkDown, Assets.batWalkUp, Assets.batWalkLeft, Assets.batWalkRight,
  				  Assets.batWalkDown, Assets.batWalkUp, Assets.batWalkLeft, Assets.batWalkRight, 
				  x, y, attacker.getMoveSpeed(), 32, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
    	} else if(attacker == Cards.golem) {
    		Attacker a = new Attacker(screen, Assets.golemWalkDown, Assets.golemWalkUp, Assets.golemWalkLeft, Assets.golemWalkRight,
  				  Assets.golemAttackDown, Assets.golemAttackUp, Assets.golemAttackLeft, Assets.golemAttackRight, 
				  x, y, attacker.getMoveSpeed(), 64, 64, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed());
    		a.setDeath(Assets.golemDeath, 1, 1, 1);
//    		a.setDeath(Assets.blood, 0.5f, 0.5f, 0.5f);
    		return a;
    	} else if(attacker == Cards.mage) {
    		return new Attacker(screen, Assets.mageWalkDown, Assets.mageWalkUp, Assets.mageWalkLeft, Assets.mageWalkRight,
  				  Assets.mageIdleDown, Assets.mageIdleUp, Assets.mageIdleLeft, Assets.mageIdleRight, 
  				  x, y, attacker.getMoveSpeed(), 16, 32, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed(),
				  Assets.arcaneOrb, 16, 16);
    	} else if(attacker == Cards.brainmonster) {
    		return new Attacker(screen, Assets.brainmonsterWalkDown, Assets.brainmonsterWalkUp, Assets.brainmonsterWalkLeft, Assets.brainmonsterWalkRight,
  				  Assets.brainmonsterWalkDown, Assets.brainmonsterWalkUp, Assets.brainmonsterWalkLeft, Assets.brainmonsterWalkRight, 
  				  x, y, attacker.getMoveSpeed(), 16, 25, team, attacker.getHealth(), attacker.getDamage(), attacker.getRange(), attacker.getAttackSpeed(),
				  Assets.gasOrb, 16, 16);
    	} else {
    		return null;
    	}
    }
}