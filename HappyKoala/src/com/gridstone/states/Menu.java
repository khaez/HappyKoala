package com.gridstone.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.gridstone.handlers.GameStateManager;

public class Menu extends GameState{
	
	Stage stage;
	BitmapFont font;
	TextureAtlas atlas;
	Skin skin;
	TextButton button;
	float delta;
	
//	Texture play_slctd_btn;
//	Texture tutorial_btn;
//	Texture tutorial_slctd_btn;
//	Texture option_btn;
//	Texture option_slctd_btn;
//	Texture score_btn;
//	Texture score_slctd_btn;
	
	Texture play_btn = new Texture(Gdx.files.internal("images/screens/menu/PlayButton.png"));
	Sprite Splay_btn = new Sprite(play_btn);
	public Menu(GameStateManager gsm)
	{
		super(gsm);
	}
	
	public void handleInput(){};
	
	public void update(float dt){
		delta = dt;
	};
	
	public void dispose(){
		sb.dispose();
		skin.dispose();
		atlas.dispose();
		stage.dispose();
	}

	@Override
	public void render(){
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		sb.begin();
		stage.draw();
		sb.end();
	}

}