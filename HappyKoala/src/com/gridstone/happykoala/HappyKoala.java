package com.gridstone.happykoala;

import com.badlogic.gdx.Game;
import com.gridstone.screens.Splash;

public class HappyKoala extends Game {
	
	public static final String Log = "KoalaLog";
	
//	public static final String TITLE = "Happy Koala";
//	public static final int V_WIDTH = 1280;
//	public static final int V_HEIGHT = 720;
//	public static final int SCALE = 2;
	
	@Override
	public void create() {
		setScreen(new Splash(this));
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
