package com.abstractlabs.oefen;

import java.util.Random;

public class Map {
	private int[][] mapPath; //Used for the straight up path for walking, so entities know where they are allowed to go.
	private int[][] mapTiles; //Used to display the tiles.
	private int[][] mapOverlay; //Used if any overlay is added. (Thinking we could have a bridge be built like this)(Maybe later, like waterfall, trees?)
	private int[][] mapTowers; //Used to tell the game where towers are allowed to be placed.
	private int blueStart;
	private int redStart;
	
	public Map(int[][] mapPath, int[][] mapTiles, int[][] mapOverlay, int[][] mapTowers, int blueStart, int redStart) {
		this.mapPath = mapPath;
		this.mapTiles = mapTiles;
		this.mapOverlay = mapOverlay;
		this.mapTowers = mapTowers;
		this.blueStart = blueStart;
		this.redStart = redStart;
	}
	
	public int[][] getPath() {
		return this.mapPath;
	}
	
	public int[][] getTiles() {
		return this.mapTiles;
	}
	
	public int[][] getOverlay() {
		return this.mapOverlay;
	}
	
	public int[][] getTowers() {
		return this.mapTowers;
	}
	
	public int getBlueStart() {
		return this.blueStart;
	}
	
	public int getRedStart() {
		return this.redStart;
	}

	/////////////////////////////////////////////////// Static Class Start ///////////////////////////////////////////////////
	
	private static int[][] mapPath1 = 
{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,3,1,1,1,1,1,4,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,1,1,1,1,1,1,2,0,0,0,0,0,5,1,1,1,1,1,1,4,0,0,0,0,0,3,1,1,1,1,1,1,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,5,1,1,1,1,1,2,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private static int[][] mapTiles1 = 
{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,3,1,1,1,1,1,4,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,0,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,0,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,11,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,0,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,1,1,1,1,1,2,0,0,0,0,0,5,1,8,7,7,9,1,4,0,0,0,0,0,3,1,1,1,1,1,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,0,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,11,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,0,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,0,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,5,1,1,1,1,1,2,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private static int[][] mapOverlay1 = 
{{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
	
	private static int[][] mapTowers1 = 
		{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,1,2,2,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,2,2,2,9,0,0,0,0,2,2,2,2,2,2,2,1,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public static Map map1 = new Map(mapPath1, mapTiles1, mapOverlay1, mapTowers1, 8, 8);
	
	public static Map generateMap1() {
		int[][] mapPath = Map.mapPath1;
		int[][] mapTiles = Map.mapTiles1;
		int[][] mapOverlay = Map.mapOverlay1;
		int[][] mapTowers = Map.mapTowers1;
		
		Random rand = new Random();
        for(int i=0; i<mapTiles.length; i++) {
	    	for(int k=0; k<mapTiles[i].length; k++) {
	    		if(mapTiles[i][k] == 0) {
	    			int temp = rand.nextInt(30);
	    			if(temp == 0) {
	    				mapTiles[i][k] = 20;
	    			}
	    		} else if(mapTiles[i][k] == 11) {
	    			int temp = rand.nextInt(6);
	    			if(temp == 0) {
	    				mapTiles[i][k] = 11;
	    			} else if(temp == 1) {
	    				mapTiles[i][k] = 12;
	    			} else if(temp == 2) {
	    				mapTiles[i][k] = 13;
	    			} else if(temp == 3) {
	    				mapTiles[i][k] = 14;
	    			} else if(temp == 4) {
	    				mapTiles[i][k] = 15;
	    			} else if(temp == 5) {
	    				mapTiles[i][k] = 16;
	    			}
	    		}
	    	}
        }
        
        return new Map(mapPath, mapTiles, mapOverlay, mapTowers, 8, 8);
	}
	
	public static Map generateRandomMap() {
		int[][] mapPath = new int[17][36];
		int[][] mapTiles = new int[17][36];
		int[][] mapOverlay = new int[17][36];
		int[][] mapTowers = new int[17][36];
		
		Random rand = new Random();
		
		//Grass generator
		for(int i=0; i<mapTiles.length; i++) {
			for(int k=0; k<mapTiles[i].length; k++) {
				int temp1 = rand.nextInt(60)+1;
				int temp2 = rand.nextInt(temp1);
				if(temp2==0) {
					mapTiles[i][k] = 20;
				} else {
					mapTiles[i][k] = 0;
				}
				mapPath[i][k] = 0;
				mapOverlay[i][k] = -1;
				mapTowers[i][k] = k<18?0:9;
				
				if(i==0) {
					mapPath[i][k] = 9;
					mapTiles[i][k] = Tile.WATER_BOTTOM;
					mapTowers[i][k] = 2;
				}
			}
		}
		
		//Starting point
		int start = rand.nextInt(16)+1;
		mapTiles[start][3] = 1;
		mapPath[start][3] = 1;
		mapPath[start][2] = 1;
		mapTowers[start][3] = 2;
		mapTowers[start][2] = 1;
		int blueStart = 16-start;
		
		for(int i=1; i<29; i++) {
			int turn = rand.nextInt(2);
			if(turn == 0) {
				int temp = rand.nextInt(2);
				if(temp == 0 && start != 1) { //turn up
					mapTiles[start][3+i] = 2;
					mapPath[start][3+i] = 2;
					mapTowers[start][3+i] = 2;
					int timesvertical = rand.nextInt(start);
					timesvertical = timesvertical<2?2:timesvertical;
					//System.out.println(timesvertical);
					for(int k=1; k<timesvertical; k++) {
						mapTiles[start-k][3+i] = 30;
						mapPath[start-k][3+i] = 1;
						mapTowers[start-k][3+i] = 2;
						if(k==timesvertical-1) {
							mapTiles[start-k][3+i] = 3;
							mapPath[start-k][3+i] = 3;
						}
					}
					start -= timesvertical-1;
				} else if(temp == 1 && start != 16) { //turn down
					mapTiles[start][3+i] = 4;
					mapPath[start][3+i] = 4;
					mapTowers[start][3+i] = 2;
					int timesvertical = rand.nextInt(16-start);
					if(timesvertical < 2) {
						timesvertical = 2;
					}
					timesvertical = timesvertical<2?2:timesvertical;
					//System.out.println(timesvertical);
					for(int k=1; k<timesvertical; k++) {
						mapTiles[start+k][3+i] = 30;
						mapPath[start+k][3+i] = 1;
						mapTowers[start+k][3+i] = 2;
						if(k==timesvertical-1) {
							mapTiles[start+k][3+i] = 5;
							mapPath[start+k][3+i] = 5;
						}
					}
					start += timesvertical-1;
				} else {
					mapTiles[start][3+i] = 1;
					mapPath[start][3+i] = 1;
					mapTowers[start][3+i] = 2;
				}
			} else {
				mapTiles[start][3+i] = 1;
				mapPath[start][3+i] = 1;
				mapTowers[start][3+i] = 2;
			}
		}

		mapTiles[start][32] = 1;
		mapPath[start][32] = 1;
		mapPath[start][33] = 1;
		mapTowers[start][32] = 2;
		mapTowers[start][33] = 8;
		int redStart = 16-start;
		
		//Water
		int waterStart = rand.nextInt(4)+13;
		int waterEnd = rand.nextInt(4)+16;
		
		for(int i=0; i<mapTiles.length; i++) {
			for(int k=waterStart; k<waterEnd+1; k++) {
				if(mapTiles[i][k] == 0 || mapTiles[i][k] == 20 || mapTiles[i][k] == Tile.WATER_BOTTOM) {
					mapTiles[i][k] = 7;
				} else if(mapTiles[i][k] == 1 || mapTiles[i][k] == 2 || mapTiles[i][k] == 3 || mapTiles[i][k] == 4 || mapTiles[i][k] == 5 || mapTiles[i][k] == 30) {
					mapOverlay[i][k] = mapTiles[i][k];
					mapTiles[i][k] = 7;
				}
				mapTowers[i][k] = 2;
			}
		}
		for(int i=0; i<mapTiles.length; i++) {
			for(int k=waterStart; k<waterEnd+1; k+=(waterEnd-waterStart)) {
				if(mapTiles[i][k] == 7) {
					mapTiles[i][k] = k==waterStart?8:9;
				}
				if(i==0) {
					mapTiles[i][k] = k==waterStart?Tile.WATER_TOPRIGHT_CORNER:Tile.WATER_TOPLEFT_CORNER;
				}
			}
		}

        return new Map(mapPath, mapTiles, mapOverlay, mapTowers, blueStart, redStart);
	}
}