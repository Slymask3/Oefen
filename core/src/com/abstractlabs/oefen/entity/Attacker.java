package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.entity.other.TempText;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Attacker extends Entity {
	Animation texture;
    float speed;
    public boolean walking = false;
    public boolean attacking = false;
    float state = 0;
	int dir;
	Entity target;
	Animation walkDown, walkUp, walkLeft, walkRight, attackDown, attackUp, attackLeft, attackRight;

    public Attacker(Animation walkDown, Animation walkUp, Animation walkLeft, Animation walkRight, 
    				Animation attackDown, Animation attackUp, Animation attackLeft, Animation attackRight, 
    				float x, float y, float speed, float width, float height, Map map, String team, int hp, int dmg, int range) {
    	super(walkDown.getKeyFrame(0, 0), x, y, width, height, map, team, hp, dmg, range);
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
    
    @Override
    public void draw(Batch batch, float alpha){
    	state += Gdx.graphics.getDeltaTime();
    	
    	if(this.team == "Blue") {
    		batch.setColor(0.8f, 0.8f, 1, 1);
    	} else {
    		batch.setColor(1, 0.8f, 0.8f, 1);
    	}
        batch.draw(texture.getKeyFrame(state, 0), x, y, width, height);
		batch.setColor(1, 1, 1, 1);
        
        batch.setColor(1, 0, 0, 1);
        batch.draw(Assets.hpbar, x, y+height);
        batch.setColor(0, 1, 0, 1);
        double php = (double)hp/maxhp;
        batch.draw(Assets.hpbar, x, y+height, Math.round(php*32), 4);
        batch.setColor(1, 1, 1, 1);
    }
    
    int tick;
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
        		tick = 0;
        		target.damage(dmg);
        		if(target.isDead()) {
        			attacking = false;
        			walking = true;
        			target = null;
        		}
        	}
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
    	TempText temp = new TempText("-"+amount, x, y, 1f, 0f, 0f, mapObj);
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
    
    ///////////////////////////////////////////////////////////// STATIC CLASS START ///////////////////////////////////////////////////////

    public static String GOBLIN = "Goblin";
    public static String FAIRY = "Fairy";
    
    public static Attacker createAttacker(String attacker, float x, float y, Map map, String team) {
    	if(attacker == GOBLIN) {
    		return new Attacker(Assets.goblinWalkDown, Assets.goblinWalkUp, Assets.goblinWalkLeft, Assets.goblinWalkRight,
    				  Assets.goblinAttackDown, Assets.goblinAttackUp, Assets.goblinAttackLeft, Assets.goblinAttackRight, 
    				  x, y, 
    				  1f, //speed
    				  32, //width
    				  32, //height
    				  map, team, 
    				  30, //health
    				  7, //damage
    				  16); //range
    	} else if(attacker == FAIRY) {
    		return new Attacker(Assets.fairyWalkDown, Assets.fairyWalkUp, Assets.fairyWalkLeft, Assets.fairyWalkRight,
  				  Assets.fairyWalkDown, Assets.fairyWalkUp, Assets.fairyWalkLeft, Assets.fairyWalkRight, 
  				  x, y, 
  				  1.5f, //speed
  				  32, //width
  				  48, //height
  				  map, team, 
  				  20, //health
  				  12, //damage
  				  32); //range
    	} else {
    		return null;
    	}
    }
}