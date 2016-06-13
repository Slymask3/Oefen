package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Font {
	public static BitmapFont createFont(FileHandle fh, float dp) {
	    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fh);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = (int)(dp * Gdx.graphics.getDensity());
		BitmapFont font = generator.generateFont(parameter);
		generator.dispose();
		return font;
	}
}