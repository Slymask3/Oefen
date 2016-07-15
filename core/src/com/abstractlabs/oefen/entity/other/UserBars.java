package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.User;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class UserBars extends Actor {
	private User blue, red;
	private GlyphLayout layout;
	private BitmapFont font;
	
	public UserBars(User blue, User red) {
		this.blue = blue;
		this.red = red;
		this.layout = new GlyphLayout();
        this.font = Font.create(Font.sufrimeda, 26, 1);
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		font.setColor(0, 1, 0.3f, 1);
		layout.setText(font, blue.getUsername());
		font.draw(batch, layout, 5, Oefen.HEIGHT-5);

		font.setColor(0.7f, 0.7f, 0.7f, 1);
		layout.setText(font, blue.getElo()+" OP");
		font.draw(batch, layout, 147-layout.width-5, Oefen.HEIGHT-5);
//		font.draw(batch, layout, 5, Oefen.HEIGHT-10-layout.height);
		
		font.setColor(1, 0, 0.3f, 1);
		layout.setText(font, red.getUsername());
		font.draw(batch, layout, Oefen.WIDTH-5-layout.width, Oefen.HEIGHT-5);

		font.setColor(0.7f, 0.7f, 0.7f, 1);
		layout.setText(font, red.getElo()+" OP");
		font.draw(batch, layout, Oefen.WIDTH-147+5, Oefen.HEIGHT-5);
//		font.draw(batch, layout, Oefen.WIDTH-5-layout.width, Oefen.HEIGHT-10-layout.height);
		
		font.setColor(1, 1, 0, 1);
		layout.setText(font, "$"+blue.getGold());
		font.draw(batch, layout, 5, Oefen.HEIGHT-10-layout.height);
		
		font.setColor(1, 1, 0, 1);
		layout.setText(font, "$"+red.getGold());
		font.draw(batch, layout, Oefen.WIDTH-5-layout.width, Oefen.HEIGHT-10-layout.height);
	}
}