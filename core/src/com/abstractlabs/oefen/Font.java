package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Font {
	public static FileHandle sufrimeda = Gdx.files.internal("gfx/sufrimeda.ttf");
	
	public static BitmapFont create(FileHandle fh, float dp) {
	    return create(fh, dp, 0, 0, 0, 0, 1);
	}
	
	public static BitmapFont create(FileHandle fh, float dp, float bw) {
	    return create(fh, dp, bw, 0, 0, 0, 1);
	}
	
	public static BitmapFont create(FileHandle fh, float dp, float bw, float r, float g, float b) {
	    return create(fh, dp, bw, r, g, b, 1);
	}
	
	public static BitmapFont create(FileHandle fh, float dp, float bw, Color color) {
	    return create(fh, dp, bw, color.r, color.g, color.b, color.a);
	}
	
	public static BitmapFont create(FileHandle fh, float dp, float bw, float r, float g, float b, float a) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fh);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//		double ratio = (double)Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
//		double density = (double)Gdx.graphics.getDensity()*dp;
//		parameter.size = (int) (density*ratio);
//		System.out.println("dp="+dp+" | ratio="+ratio+" | size="+parameter.size+" | density="+Gdx.graphics.getDensity()+" | d/dp="+density);
//		parameter.size = (int)(dp * Gdx.graphics.getDensity());
//		parameter.size = (int) density;
		parameter.size = (int) (dp*0.6);
		parameter.borderColor = new Color(r,g,b,a);
		parameter.borderWidth = bw;
		BitmapFont font = generator.generateFont(parameter);
		generator.dispose();
//		font.getData().setScale(Gdx.graphics.getDensity());
		return font;
	}
}