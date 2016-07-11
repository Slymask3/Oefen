package com.abstractlabs.oefen.entity.tower;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.entity.other.TempText;
import com.abstractlabs.oefen.screen.ScreenGame;

public class BuddhaGold extends Tower {
	private int amount, interval, tick;
	
	public BuddhaGold(ScreenGame screen, String team, float x, float y, int hp, int dmg, int range, int amount, int interval) {
		super(screen, Assets.budhaGold, x, y, 32, 32, team, hp, dmg, range, 0, Assets.arrow, 15, 3);
		this.amount = amount;
		this.interval = interval;
		this.tick = 0;
	}
	
    @Override
    public void act(float delta){
    	tick++;
    	if(tick >= interval) {
    		tick = 0;
    		TempText text = new TempText(screen, "+"+amount, x, y, 1, 1, 0);
    		if(this.getStage() != null) {
    			this.getStage().addActor(text);
    		}
    	}
    }
}