package com.abstractlabs.oefen.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.abstractlabs.oefen.Oefen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Oefen";
		config.width = 960+4;
		config.height = 480+104+54;
		new LwjglApplication(new Oefen(), config);
	}
}
