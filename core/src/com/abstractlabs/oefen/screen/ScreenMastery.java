package com.abstractlabs.oefen.screen;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.entity.Book;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScreenMastery extends ScreenAdapter {
	public Oefen game;
	OrthographicCamera guiCam;

	Stage stage;
	TextButton button;
    TextButton buttonM;
    TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    
    float state = 0;
    
    private TextureRegion currentFrame;
    
    final Book book = new Book(140, 20);
    
	public ScreenMastery(Oefen oefen) {
		this.game = oefen;
		
		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
		guiCam.position.set(Oefen.WIDTH / 2, Oefen.HEIGHT / 2, 0);
		
		BitmapFont font2 = Font.createFont(Gdx.files.internal("gfx/sufrimeda.ttf"), 30);

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		font = new BitmapFont(Gdx.files.internal("gfx/oefenfont2.fnt"));
		skin = new Skin();
		buttonAtlas = new TextureAtlas(Gdx.files.internal("gfx/buttons.txt"));
		skin.addRegions(buttonAtlas);
		textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = font2;
		textButtonStyle.up = skin.getDrawable("up-button");
		textButtonStyle.down = skin.getDrawable("down-button");
	
		button = new TextButton("Play"/*+Gdx.graphics.getDensity()*/, textButtonStyle);
		
		button.addListener( new ClickListener() {
	            @Override
	            public void clicked(InputEvent e, float x, float y) {
					Assets.playSound(Assets.clickSound);
					System.out.println("test");
					book.changeAnimation();
	            }
	        } );
		
		stage.addActor(button);
		stage.addActor(book);
	}

	public void update () {
//		if (Gdx.input.justTouched()) {
//			
//		}
	}

	public void draw () {		
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		guiCam.update();
		game.batch.setProjectionMatrix(guiCam.combined);

		game.batch.disableBlending();
		game.batch.begin();
		game.batch.draw(Assets.backgroundMastery, 0, 0, Oefen.WIDTH, Oefen.HEIGHT);
		game.batch.end();
		game.batch.enableBlending();
		game.batch.begin();
		
		game.batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	@Override
	public void render (float delta) {
		draw();
		update();
	}

	@Override
	public void pause () {
		Settings.save();
	}
}

