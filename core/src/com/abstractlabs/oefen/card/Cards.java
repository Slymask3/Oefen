package com.abstractlabs.oefen.card;

import java.util.ArrayList;
import java.util.List;

import com.abstractlabs.oefen.Assets;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Cards {
	private String type, name;
	private TextureRegion texture;
	private int price;
	private float speed;
	private int hp, dmg, range, attackspeed, custom;
	private int id;
	
	public Cards(String type, String name, TextureRegion texture, int price, float speed, int hp, int dmg, int range, int attackspeed, int custom) {
		this.type = type;
		this.name = name;
		this.texture = texture;
		this.price = price;
		this.speed = speed;
		this.hp = hp;
		this.dmg = dmg;
		this.range = range;
		this.attackspeed = attackspeed;
		this.custom = custom;
		this.id = all.size();
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
	
	public int getPrice() {
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
	
	public int getCustom() {
		return this.custom;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String toString() {
		String str = "";
		str += "Type: "+this.getType()+" | ";
		str += "Name: "+this.getName();
		return str;
	}
	
	/////////////////////////////////////////////////// STATIC CLASS START ////////////////////////////////////////////////////////////////
	public static List<Cards> all = new ArrayList<Cards>();
	////////////////////Attackers///////////////////Type////////Name///////////////Texture//////////////////Price/Speed///HP/DMG/Range/AS//Custom/
	public static Cards goblin         = new Cards("Attacker", "Goblin",           Assets.cardGoblin,         20,    1f,  30,  7, 16, 100,  0);
	public static Cards fairy          = new Cards("Attacker", "Fairy",            Assets.cardFairy,          30,  1.2f,  20,  7, 16, 100,  0);
	public static Cards goblinDarkMage = new Cards("Attacker", "Dark Mage Goblin", Assets.cardGoblinDarkMage, 30, 1.05f,  20,  9, 32, 100,  0);
	public static Cards spiderRed      = new Cards("Attacker", "Red Spider",       Assets.cardSpiderRed,      10,  1.3f,  10,  4, 16, 100,  0);
	public static Cards crystalBlue    = new Cards("Attacker", "Blue Crystal",     Assets.cardCrystalBlue,   200,  1.1f,  40,  3, 80, 100,  0);
	public static Cards knight         = new Cards("Attacker", "Knight",           Assets.cardKnight,         90,  0.8f,  60, 12, 16, 100,  0);
	public static Cards bat            = new Cards("Attacker", "Bat",              Assets.cardBat,            10,  1.1f,  15,  6, 16, 100,  0);
	public static Cards golem          = new Cards("Attacker", "Golem",            Assets.cardGolem,         600,  0.8f, 200,  7, 16, 100,  0);
	public static Cards mage           = new Cards("Attacker", "Mage",             Assets.cardMage,           50,  1.1f,  25, 11, 48,  50,  0);
	public static Cards brainmonster   = new Cards("Attacker", "Brain Monster",    Assets.cardBrainmonster,   50,  1.2f, 110,  6, 48,  20,  0);
	public static Cards elfHealer      = new Cards("Attacker", "Elf Healer",       Assets.cardElfHealer,      50,  1.1f,  60,  0, 48,  50,  5);//Heal Amount
	public static Cards viking         = new Cards("Attacker", "Viking",           Assets.cardViking,        101,    1f,  80,  9, 16, 100,  0);
	public static Cards imp            = new Cards("Attacker", "Imp",              Assets.cardImp,            70,    1f,  30, 10, 16,  80,  0);
	public static Cards flameSkull     = new Cards("Attacker", "Flaming Skull",    Assets.cardFlameSkull,     20,  1.2f,  20,  1, 48,  20,  0);
	public static Cards chest          = new Cards("Attacker", "Chest",            Assets.cardChest,         303,  1.1f,  77,  5, 16,  80,  0);
	public static Cards eyeball        = new Cards("Attacker", "Eyeball",          Assets.cardEyeball,        78,    1f,  30,  1, 48,   5,  0);
	////////////////////Towers//////////////////////Type////////Name///////////////Texture//////////////////Price/Speed///HP/DMG/Range/AS//Custom/
	public static Cards dummy          = new Cards("Tower",    "Dummy",            Assets.cardDummy,          15,    0f,  30,  0,  0,   0,  0);
	public static Cards buddhaGold     = new Cards("Tower",    "Gold Buddha",      Assets.budhaGold,         500,    0f, 100,  0,  0, 100,  5);//Gold Amount
	public static Cards wtfisthis      = new Cards("Tower",    "idk",              Assets.wtfisthis,          40,    0f,  70,  8, 48,  50,  0);
	public static Cards lazorRed       = new Cards("Tower",    "Red Lazor",        Assets.lazorRed,           60,    0f,  60,  2, 80,  10,  0);
	public static Cards flowerPurple   = new Cards("Tower",    "Purple Flower",    Assets.flowerPurple,      101,    0f, 100,  6, 80,  50,  0);
	////////////////////Spells//////////////////////Type////////Name///////////////Texture//////////////////Price/Speed///HP/DMG/Range/AS/Custom/
	public static Cards explosion      = new Cards("Spell",    "Explosion",        Assets.cardExplosion,      75,    0f,   0, 30, 48,   0,  0);
}