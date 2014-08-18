package com.gridstone.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gridstone.TweenAccessors.SpriteTween;
import com.gridstone.happykoala.HappyKoala;

public class Splash implements Screen {

	HappyKoala game;
	Texture splashTexture;
	SpriteBatch splashBatch;
	Sprite splashSprite;
	TweenManager manager;
	
	public Splash(HappyKoala game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		manager.update(delta);
		
		splashBatch.begin();
		splashSprite.draw(splashBatch);
		splashBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		splashTexture = new Texture("images/splash/Splash.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1,1,1,0);
		splashSprite.setX(Gdx.graphics.getWidth() / 2 - (splashSprite.getWidth()/2));
		splashSprite.setY(Gdx.graphics.getHeight() / 2 - (splashSprite.getHeight()/2));
		
		splashBatch = new SpriteBatch();
		
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		
		manager = new TweenManager();
		
		TweenCallback cb = new TweenCallback()
		{
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenCompleted();
			}
		};
		
		Tween.to(splashSprite, SpriteTween.ALPHA, 2.5f).target(1).ease(TweenEquations.easeInQuad).repeatYoyo(1,2.5f).setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
	}
	
	private void tweenCompleted()
	{
		game.setScreen(new MainMenu(game));
	}

	@Override
	public void hide() {
		//Gdx.app.log("Splash", "Hide");
	}

	@Override
	public void pause() {
		//Gdx.app.log("Splash", "pause");
	}

	@Override
	public void resume() {
		//Gdx.app.log("Splash", "resume");
	}

	@Override
	public void dispose() {
		//Gdx.app.log("Splash", "dispose");
	}
}
