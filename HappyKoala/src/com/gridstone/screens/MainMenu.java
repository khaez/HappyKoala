package com.gridstone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.gridstone.happykoala.HappyKoala;
import com.gridstone.happykoala.World;

public class MainMenu implements Screen{
	
	HappyKoala game;
	Stage stage;
	BitmapFont font;
	TextureAtlas atlas;
	Skin skin;
	SpriteBatch batch;
	TextButton play_button;
	TextButton tutorial_button;
	TextButton score_button;
	TextButton option_button;
	Group group;
	
	BitmapFont black;
	
	public MainMenu(HappyKoala game)
	{
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		batch.begin();
		stage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		if(stage == null)
		{
			stage = new Stage(width, height, true);
		}
		
		stage.clear();
		System.out.println(width);
		Gdx.input.setInputProcessor(stage);
		
		// Adding the play button
		TextButtonStyle play_style = new TextButtonStyle();
		play_style.up = skin.getDrawable("PlayButton");
		play_style.down = skin.getDrawable("PlayButtonSelected");
		play_style.font = black;
		
		play_button = new TextButton("", play_style);
		play_button.setWidth(642);
		play_button.setHeight(120);
		
		play_button.setX(width / 2 - play_button.getWidth() / 2);
		play_button.setY(height/ 2 + (Gdx.graphics.getHeight()/4));
		
		// Adding the Tutorial Button
		TextButtonStyle tutorial_style = new TextButtonStyle();
		tutorial_style.up = skin.getDrawable("TutorialsButtons");
		tutorial_style.down = skin.getDrawable("TutorialButtonSelected");
		tutorial_style.font = black;
		
		tutorial_button = new TextButton("", tutorial_style);
		tutorial_button.setWidth(642);
		tutorial_button.setHeight(120);
		
		tutorial_button.setX(width / 2 - tutorial_button.getWidth() / 2);
		tutorial_button.setY(play_button.getY() - (play_button.getHeight() + (play_button.getHeight()/2)));
		
		// Adding the score button
		TextButtonStyle score_style = new TextButtonStyle();
		score_style.up = skin.getDrawable("ScoreButton");
		score_style.down = skin.getDrawable("ScoreButtonSelected");
		score_style.font = black;
		
		score_button = new TextButton("", score_style);
		score_button.setWidth(642);
		score_button.setHeight(120);
		
		score_button.setX(width / 2 - score_button.getWidth() / 2);
		score_button.setY(tutorial_button.getY() - (play_button.getHeight() + (play_button.getHeight()/2)));
		
		// Adding the option button
		TextButtonStyle option_style = new TextButtonStyle();
		option_style.up = skin.getDrawable("OptionsButton");
		option_style.down = skin.getDrawable("OptionsButtonSelected");
		option_style.font = black;
		
		option_button = new TextButton("", option_style);
		option_button.setWidth(642);
		option_button.setHeight(120);
		
		option_button.setX(width / 2 - option_button.getWidth() / 2);
		option_button.setY(score_button.getY() - (play_button.getHeight() + (play_button.getHeight()/2)));
		
		// Detects Action
		play_button.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button){
				System.out.println("Play");
				game.setScreen(new World(game));
				return true;
			}
		
//		public void touchUp(InputEvent event, float x, float y, int pointer,
//				int button){
//			System.out.println("Not Selected");
//		}
		});
		
		tutorial_button.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button){
//				System.out.println("Tutorial");
				return true;
			}
		
//		public void touchUp(InputEvent event, float x, float y, int pointer,
//				int button){
//			System.out.println("Not Selected");
//		}
		});
		
		option_button.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button){
				System.out.println("Option");
				return true;
			}
		
//		public void touchUp(InputEvent event, float x, float y, int pointer,
//				int button){
//			System.out.println("Not Selected");
//		}
		});
		
		score_button.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button){
				System.out.println("Score");
				return true;
			}
		
//		public void touchUp(InputEvent event, float x, float y, int pointer,
//				int button){
//			System.out.println("Not Selected");
//		}
		});
		
		// Adding actors
		group = new Group();
		
		group.addActor(play_button);
		group.addActor(tutorial_button);
		group.addActor(score_button);
		group.addActor(option_button);
		
		stage.addActor(group);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		skin = new Skin();
		atlas = new TextureAtlas("images/screens/menu/button.pack");
		skin.addRegions(atlas);
		black = new BitmapFont();
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		stage.dispose();
	}
}