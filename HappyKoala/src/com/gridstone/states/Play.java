package com.gridstone.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.gridstone.handlers.GameStateManager;

public class Play extends GameState{
	
	public Play(GameStateManager gsm)
	{
		super(gsm);
	}
	
	public void handleInput(){};
	
	public void update(float dt){};
	
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		//batch.draw(bucketImage, bucket.x, bucket.y);
		sb.end();
	};
	
	public void dispose(){};
}
