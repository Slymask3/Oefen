package com.abstractlabs.oefen.desktop;

import com.abstractlabs.oefen.Oefen;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Oefen";
		config.width = Oefen.WIDTH;
		config.height = Oefen.HEIGHT;
		config.addIcon("gfx/icon_32.png", Files.FileType.Internal);
		new LwjglApplication(new Oefen(), config);
	}
}