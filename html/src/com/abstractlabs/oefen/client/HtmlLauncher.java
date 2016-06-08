package com.abstractlabs.oefen.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.abstractlabs.oefen.Oefen;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(1136, 640);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new Oefen();
        }
}