package com.gridstone.handlers;

import java.util.Stack;

import com.gridstone.happykoala.HappyKoala;
import com.gridstone.states.GameState;
import com.gridstone.states.Menu;
import com.gridstone.states.Play;

public class GameStateManager {
	
	private HappyKoala game;
	
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 1;
	public static final int MENU = 0;
	
	public GameStateManager(HappyKoala game)
	{
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(MENU);
	}
	
	public HappyKoala game(){ return game; }
	
	public void update(float dt)
	{
		gameStates.peek().update(dt);
	}
	
	public void render()
	{
		gameStates.peek().render();
	}
	
	private GameState getState(int state)
	{
		if(state == PLAY)
		{
			return new Play(this);
		}
		
		if(state == MENU)
		{
			return new Menu(this);
		}
		
		return null;
	}
	
	public void setState(int state)
	{
		popState();
		pushState(state);
	}
	
	public void pushState(int state)
	{
		gameStates.push(getState(state));
	}
	
	public void popState()
	{
		GameState g = gameStates.pop();
		g.dispose();
	}
	
}
