package com.abstractlabs.oefen.screen;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class ScreenMainMenu extends ScreenAdapter {
	Oefen game;
	OrthographicCamera guiCam;
	Rectangle playBounds;
	Vector3 touchPoint;
	Button play;
	
	Stage stage;
    TextButton button;
    TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
	
	public ScreenMainMenu (Oefen game) {
		this.game = game;

		guiCam = new OrthographicCamera(1136, 640);
		guiCam.position.set(1136 / 2, 640 / 2, 0);
		playBounds = new Rectangle(50, 640-250, 200, 53);
		touchPoint = new Vector3();
		play = new Button();
		play.setPosition(150, 640-250);
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("gfx/sufrimeda.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		
		stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont(Gdx.files.internal("gfx/oefenfont2.fnt"));
        //font.getData().setScale(0.9f, 0.9f);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("gfx/buttons.txt"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font12;
        textButtonStyle.up = skin.getDrawable("up-button");
        textButtonStyle.down = skin.getDrawable("down-button");
        //textButtonStyle.checked = skin.getDrawable("checked-button");
        button = new TextButton("Play Ranked", textButtonStyle);
        button.addAction(Actions.scaleTo(50, 50, 0.5f));
        stage.addActor(button);
	}

	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				game.batch.enableBlending();
				game.batch.begin();
				game.batch.draw(Assets.playHover, 50, 640-250, 200, 53);
				game.batch.end();
				game.setScreen(new ScreenGame(game));
				return;
			}
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
		game.batch.draw(Assets.backgroundMainMenuRegion, 0, 0, 1136, 640);
		game.batch.end();

		game.batch.enableBlending();
		game.batch.begin();
		game.batch.draw(Assets.play, 50, 640-250, 200, 53);
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
	public void pause () {
		Settings.save();
	}
}
