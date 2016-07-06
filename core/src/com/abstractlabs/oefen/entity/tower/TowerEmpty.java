package com.abstractlabs.oefen.entity.tower;

import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.screen.ScreenGame;

public class TowerEmpty extends Tower {
	public TowerEmpty(ScreenGame screen) {
		super(screen);
	}
	
	public int getZOrder() {
		return 0;
	}
}