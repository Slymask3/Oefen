package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.card.Card;
import com.abstractlabs.oefen.card.CardAttacker;
import com.abstractlabs.oefen.entity.Entity;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class CardInfo extends Entity {
	private Card card;
    private BitmapFont font;
	
	public CardInfo(ScreenGame screen, Card card) {
		super(screen, card.getX()-32, card.getY()+64);
		this.card = card;
		this.font = Font.create(Font.sufrimeda, 15, 1);
	}
	
	@Override
    public void draw(Batch batch, float alpha){
		batch.draw(Assets.cardinfo, x, y);
        font.draw(batch, "Cost: $"+Math.round(card.getCost()), x+10, y+70);
        font.draw(batch, "Health: "+card.getHealth(), x+10, y+60);
        font.draw(batch, "Damage: "+card.getDamage(), x+10, y+50);
        font.draw(batch, "Range: "+card.getRange(), x+10, y+40);
        font.draw(batch, "Attack Speed: "+card.getAttackSpeed(), x+10, y+30);
        if(card.getClass() == CardAttacker.class) {
            font.draw(batch, "Move Speed: "+card.getMoveSpeed(), x+10, y+20);
        }
    }
}