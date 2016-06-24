package com.abstractlabs.oefen.entity.tower;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.entity.Tower;

public class Wtfisthis extends Tower {
	public Wtfisthis(Map map, String team, float x, float y) {
		super(Assets.wtfisthis, x, y, 32, 32, map, team, 100, 10, 32);
	}
}