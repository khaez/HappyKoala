package com.gridstone.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gridstone.handlers.GameStateManager;
import com.gridstone.happykoala.HappyKoala;

public abstract class GameState {

		protected GameStateManager gsm;
		protected HappyKoala game;
		
		protected SpriteBatch sb;
		protected OrthographicCamera cam;
		protected OrthographicCamera hudCam;
		
		protected GameState(GameStateManager gsm)
		{
			this.gsm = gsm;
			game = gsm.game();
		}
		
		public abstract void handleInput();
		public abstract void update(float dt);
		public abstract void render();
		public abstract void dispose();
		
}
