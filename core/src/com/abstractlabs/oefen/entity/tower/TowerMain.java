package com.abstractlabs.oefen.entity.tower;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.Range;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.abstractlabs.oefen.screen.ScreenMainMenu;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class TowerMain extends Tower {
	int xhp;
	int yhp;
    BitmapFont font;
	
	public TowerMain(ScreenGame screen, String team, float x, float y) {
		super(screen, Assets.mainTower, x, y, 32, 64, team, 1000, 5, 80, 20, Assets.arrow, 15, 3);
		xhp = team=="Blue"?2:1218;
		yhp = 122+13;
		font = Font.create(Font.sufrimeda, 30, 2);
		
//		if(team == "Blue") {
//			this.setOrder(3+(17*screen.getMap().getBlueStart()));
//		} else {
//			this.setOrder(32+(17*screen.getMap().getRedStart()));
//		}
	}
	
	@Override
    public void draw(Batch batch, float alpha){
		if(team=="Blue") {
			batch.setColor(0.7f, 0.7f, 1, 1);
		} else {
			batch.setColor(1, 0.7f, 0.7f, 1);
		}
        batch.draw(texture, x, y, width, height);
        batch.setColor(1, 1, 1, 1);

        double php = (double)hp/maxhp;
        double php2 = (double)(maxhp-hp)/maxhp;
        
        batch.setColor(1, 0, 0, 1);
        batch.draw(Assets.hpbar, x, y+45);
        batch.setColor(0, 1, 0, 1);
        batch.draw(Assets.hpbar, x, y+45, Math.round(php*32), 4);
        batch.setColor(1, 1, 1, 1);
        
        batch.setColor(1, 0, 0, 1);
        batch.draw(Assets.mainhp, xhp, yhp, 60, 544);
        batch.setColor(0, 1, 0, 1);
        batch.draw(Assets.mainhp, xhp, yhp, 60, Math.round(php*544));
        batch.setColor(1, 1, 1, 1);
        
        font.setColor((float)(php2), (float)php, 0, 1);
        font.draw(batch, hp+"", xhp, 400, 60, 1, true);
        font.setColor(1, 1, 1, 1);
        
        if(Settings.showRangebox) {
            Range.drawRectangle(batch, screen.getOefen().sr, rangebox.x, rangebox.y, rangebox.width, rangebox.height, 1, 0, 0);
        }
		if(Settings.showHitbox) {
	        Range.drawRectangle(batch, screen.getOefen().sr, hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0, 0, 1);
		}
		//font.draw(batch, this.getZIndex()+"", x+16, y+16);
    }
    
	@Override
    protected void removeIfDead() {
    	if(isDead()) {
        	this.screen.getOefen().setScreen(new ScreenMainMenu(this.screen.getOefen()));
        }
    }
}