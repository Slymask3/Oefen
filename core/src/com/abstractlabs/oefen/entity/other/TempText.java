package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.entity.Entity;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class TempText extends Entity {
	private String text;
	private float r, g, b;
    private int tick;
    private BitmapFont font;
	
	public TempText(ScreenGame screen, String text, float x, float y, float r, float g, float b) {
		super(screen, x, y);
		this.text = text;
		this.r = r;
		this.g = g;
		this.b = b;
		this.tick = 50;
		this.font = Font.create(Font.sufrimeda, 15, 1);
	}
	
	@Override
    public void draw(Batch batch, float alpha){
		double per = (double)tick/50;
		font.setColor(r, g, b, (float) per);
        font.draw(batch, text, x+10, y+20);
        font.setColor(1f, 1f, 1f, 1f);
    }
    
    @Override
    public void act(float delta){
    	y++;
    	tick--;
    	
    	if(tick <= 0) {
    		//this.remove();
    		this.getParent().removeActor(this);
    	}
    }

	//no targets for temptext entity
	@Override
	public void findTarget() {}
}