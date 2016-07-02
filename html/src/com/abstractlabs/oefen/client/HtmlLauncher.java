package com.abstractlabs.oefen.client;

import com.abstractlabs.oefen.Oefen;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class HtmlLauncher extends GwtApplication {
    @Override
    public GwtApplicationConfiguration getConfig () {
        return new GwtApplicationConfiguration(Oefen.WIDTH, Oefen.HEIGHT);
    }

    @Override
    public ApplicationListener createApplicationListener () {
        return new Oefen();
    }
}