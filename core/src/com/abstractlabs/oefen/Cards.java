package com.abstractlabs.oefen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Cards {
	private String type, name;
	private TextureRegion texture;
	private float price, speed;
	private int hp, dmg, range, attackspeed;
	
	public Cards(String type, String name, TextureRegion texture, float price, float speed, int hp, int dmg, int range, int attackspeed) {
		this.type = type;
		this.name = name;
		this.texture = texture;
		this.price = price;
		this.speed = speed;
		this.hp = hp;
		this.dmg = dmg;
		this.range = range;
		this.attackspeed = attackspeed;
		all.add(this);
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public TextureRegion getTexture() {
		return this.texture;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public float getMoveSpeed() {
		return this.speed;
	}
	
	public int getHealth() {
		return this.hp;
	}
	
	public int getDamage() {
		return this.dmg;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public int getAttackSpeed() {
		return this.attackspeed;
	}
	
	public String toString() {
		String str = "";
		str += "Type: "+this.getType()+" | ";
		str += "Name: "+this.getName();
		return str;
	}
	
	/////////////////////////////////////////////////// STATIC CLASS START ////////////////////////////////////////////////////////////////
	public static List<Cards> all = new ArrayList<Cards>();
	////////////////////Attackers///////////////////Type////////Name///////////////Texture//////////////////Price/Speed///HP/DMG/Range/AS//
	public static Cards goblin         = new Cards("Attacker", "Goblin",           Assets.cardGoblin,         20,    1f,  30,  7, 16, 100);
	public static Cards fairy          = new Cards("Attacker", "Fairy",            Assets.cardFairy,          30,  1.2f,  20,  7, 16, 100);
	public static Cards goblinDarkMage = new Cards("Attacker", "Dark Mage Goblin", Assets.cardGoblinDarkMage, 30, 1.05f,  20,  9, 32, 100);
	public static Cards spiderRed      = new Cards("Attacker", "Red Spider",       Assets.cardSpiderRed,      10,  1.3f,  10,  4, 16, 100);
	public static Cards crystalBlue    = new Cards("Attacker", "Blue Crystal",     Assets.cardCrystalBlue,   200,  1.1f,  40,  3, 16, 100);
	public static Cards knight         = new Cards("Attacker", "Knight",           Assets.cardKnight,         90,  0.8f,  60, 12, 16, 100);
	public static Cards bat            = new Cards("Attacker", "Bat",              Assets.cardBat,            10,  1.1f,  15,  6, 16, 100);
	public static Cards golem          = new Cards("Attacker", "Golem",            Assets.cardGolem,         600,  0.8f, 200,  7, 16, 100);
	public static Cards mage           = new Cards("Attacker", "Mage",             Assets.cardMage,           50,  1.1f,  25, 11, 48,  50);
	public static Cards brainmonster   = new Cards("Attacker", "Brain Monster",    Assets.cardBrainmonster,   50,  1.2f, 110,  6, 48,  20);
	////////////////////Towers//////////////////////Type////////Name///////////////Texture//////////////////Price/Speed///HP/DMG/Range/AS//
	public static Cards dummy          = new Cards("Tower",    "Dummy",            Assets.cardDummy,          15,    0f,  30,  0,  0,   0);
	public static Cards buddhaGold     = new Cards("Tower",    "Gold Buddha",      Assets.budhaGold,         500,    0f, 100,  0,  0,   0);
	public static Cards wtfisthis      = new Cards("Tower",    "idk",              Assets.wtfisthis,          40,    0f,  70,  8, 48,  50);
	////////////////////Spells//////////////////////Type////////Name///////////////Texture//////////////////Price/Speed///HP/DMG/Range/AS//
	public static Cards explosion      = new Cards("Spell",    "Explosion",        Assets.cardExplosion,      75,    0f,   0, 30, 48,   0);
}