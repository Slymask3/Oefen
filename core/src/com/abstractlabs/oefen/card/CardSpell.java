package com.abstractlabs.oefen.card;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Range;
import com.abstractlabs.oefen.entity.Spell;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;

public class CardSpell extends Card {
	private float spellX, spellY;
	private boolean selected;
	
	 public CardSpell(ScreenGame screen, Cards card, Sound sound, String team) {
		super(screen, Card.SPELL, card, sound, team);
		this.selected = false;
	}
		
	public CardSpell(Cards card, Sound sound, String team) {
		this(null, card, sound, team);
	}

	public Spell createSpell() {
		return Spell.createSpell(screen, card, spellX, spellY, team);
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		super.draw(batch, alpha);
		
		if(selected) {
			boolean onTile = false;
			for(int i=0; i<screen.getMap().getTowers().length; i++) {
				for(int k=0; k<screen.getMap().getTowers()[i].length; k++) {
					batch.setColor(0, 1, 0, 0.3f);
					batch.draw(Assets.hoverTile, 64+k*32, (480+184)-(i*32)-32+2+13, 32, 32);
					batch.setColor(1, 1, 1, 1);
					
					if(Gdx.input.getX() >= 64+k*32 && Gdx.input.getX() < 64+k*32+32 && Oefen.HEIGHT-Gdx.input.getY() >= (480+184)-(i*32)-32+2+13 && Oefen.HEIGHT-Gdx.input.getY() < (480+184)-(i*32)-32+2+13+32) {
						Range.drawCircle(batch, screen.getOefen().sr, 64+k*32+16, (480+184)-(i*32)-32+2+13+16, range, 1, 0, 0);
						batch.setColor(1, 1, 1, 0.5f);
						batch.draw(front, 64+k*32, (480+184)-(i*32)-32+2+13, 32, 32);
						batch.setColor(1, 1, 1, 1);
						onTile = true;
					}
				}
			}
			
			if(!onTile) {
				batch.setColor(1, 1, 1, 0.5f);
				batch.draw(front, Gdx.input.getX()-16, Oefen.HEIGHT-Gdx.input.getY()-16);
				batch.setColor(1, 1, 1, 1);
			}
		}
	}
	
	public void select() {
		this.selected = true;
	}
	
	public void cancel() {
		this.selected = false;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSpellXY(float x, float y) {
		this.spellX = x;
		this.spellY = y;
	}
}