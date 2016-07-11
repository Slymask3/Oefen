package com.abstractlabs.oefen.screen;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenMainMenu extends ScreenAdapter {
	public Oefen game;
	OrthographicCamera guiCam;
	float stateTime;
	Stage stage;
	Viewport vp;
    TextButton button;
    TextButton buttonM;
    TextButtonStyle textButtonStyle;
    //BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
	
	public ScreenMainMenu(Oefen oefen) {
		this.game = oefen;

		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
		guiCam.position.set(Oefen.WIDTH/2, Oefen.HEIGHT/2, 0);
		
		vp = new FitViewport(Oefen.WIDTH, Oefen.HEIGHT);
		stage = new Stage(vp);
//        Gdx.input.setInputProcessor(stage);
        
		//playBounds = new Rectangle(50, 640-250, 200, 53);
		//touchPoint = new Vector3();
		//play = new Button();
		//play.setPosition(150, 640-250);
		
//		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("gfx/sufrimeda.ttf"));
//		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//		parameter.size = 32;
//		BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
//		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		
		//BitmapFont font2 = Font.createFont(Gdx.files.internal("gfx/sufrimeda.ttf"), 30);
		
//		stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        //font = new BitmapFont(Gdx.files.internal("gfx/oefenfont2.fnt"));
        //font.getData().setScale(0.9f, 0.9f);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("gfx/buttons.txt"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = Font.create(Font.sufrimeda, 30, 2);
        textButtonStyle.up = skin.getDrawable("up-button");
        textButtonStyle.down = skin.getDrawable("down-button");
        //textButtonStyle.checked = skin.getDrawable("checked-button");
//        textButtonStyle.up = new TextureRegionDrawable(Assets.gemBlue);
//        textButtonStyle.down = new TextureRegionDrawable(Assets.gemOrange);
        button = new TextButton("Play"/*+Gdx.graphics.getDensity()*/, textButtonStyle);
        button.addAction(Actions.scaleTo(50, 50, 0.5f));
        button.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
				Assets.playSound(Assets.clickSound);
//				game.setScreen(new ScreenGame(game, DB.getUser(game.db, "Slymask3"), DB.getUser(game.db, "HotMixtape")));
				User sly = new User("Sly", 100, 100, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,1,1,2,2,3,3,4,4,5,5,6,6});
				User mix = new User("Mix", 100, 200, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,1,1,2,2,3,3,4,4,5,5,6,6});
				game.setScreen(new ScreenGame(game, sly, mix));
            }
        } );
        
        buttonM = new TextButton("Mastery"/*+Gdx.graphics.getDensity()*/, textButtonStyle);
        buttonM.addAction(Actions.scaleTo(50, 50, 0.5f));
        buttonM.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
				Assets.playSound(Assets.clickSound);
				game.setScreen(new ScreenMastery(game));
            }
        } );
        
        buttonM.setPosition(50, 310);
		button.setPosition(50, 640-250);
        
		stage.addActor(buttonM);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);
	}

	public void update () {
		if (Gdx.input.justTouched()) {
			//guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

//			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.batch.enableBlending();
//				game.batch.begin();
//				game.batch.draw(Assets.playHover, 50, 640-250, 200, 53);
//				game.batch.end();
//				game.setScreen(new ScreenGame(game));
//				return;
//			}
		}
	}

	public void draw () {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		guiCam.update();
		game.batch.setProjectionMatrix(guiCam.combined);

		game.batch.disableBlending();
		game.batch.begin();
		game.batch.draw(Assets.backgroundMainMenuRegion, 0, 0, Oefen.WIDTH, Oefen.HEIGHT);
		game.batch.end();

		game.batch.enableBlending();
		game.batch.begin();
		//game.batch.draw(Assets.play, 50, 640-250, 200, 53);
		//play.draw(game.batch, 1f);
		game.batch.end();
		
		stage.draw();
	}

	@Override
	public void render (float delta) {
		draw();
		update();
	}

	@Override
	public void pause() {
		Settings.save();
	}

	@Override
	public void dispose() {
		stage.dispose();
	    skin.dispose();
	    buttonAtlas.dispose();
	}
}
