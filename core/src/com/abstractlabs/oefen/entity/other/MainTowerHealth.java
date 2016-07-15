package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.entity.tower.TowerMain;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MainTowerHealth extends Actor {
	private TowerMain tower;
	private BitmapFont font;
	private float x, y;
	
	public MainTowerHealth(TowerMain tower) {
		this.tower = tower;
		this.x = tower.getTeam()=="Blue"?2:1218;
		this.y = 122+13;
		font = Font.create(Font.sufrimeda, 30, 2);
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		double php = (double)tower.getHealth()/tower.getMaxHealth();
        double php2 = (double)(tower.getMaxHealth()-tower.getHealth())/tower.getMaxHealth();
        
        batch.setColor(1, 0, 0, 1);
        batch.draw(Assets.mainhp, x, y, 60, 544);
        batch.setColor(0, 1, 0, 1);
        batch.draw(Assets.mainhp, x, y, 60, Math.round(php*544));
        batch.setColor(1, 1, 1, 1);
        
        font.setColor((float)(php2), (float)php, 0, 1);
        font.draw(batch, tower.getHealth()+"", x, 400, 60, 1, true);
        font.setColor(1, 1, 1, 1);
	}
}