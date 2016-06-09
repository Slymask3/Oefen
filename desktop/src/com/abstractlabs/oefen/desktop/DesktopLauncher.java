package com.abstractlabs.oefen.desktop;

import com.abstractlabs.oefen.Oefen;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Oefen";
//		config.width = 960+4;
//		config.height = 480+104+54;
		config.width = 1136;
		config.height = 640;
		new LwjglApplication(new Oefen(), config);
	}
}
