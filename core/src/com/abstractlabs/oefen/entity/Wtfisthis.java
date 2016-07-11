package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Assets;

public class Wtfisthis extends Tower {
	public Wtfisthis(int[][] map, String team, float x, float y) {
		super(Assets.wtfisthis, x, y, 32, 32, map, team, 100, 10, 32);
	}
}