package com.gridstone.animals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Koala {
	
	//standing, walking, jumping and climbing state
	public enum State
	{
		Standing, Walking, Jumping, Climbing
	}
	
	//width and height of koala
	private final float WIDTH;
	private final float HEIGHT;
	
	//position of koala in on screen
	public final Vector2 position = new Vector2();
	
	//velocity of koala
	public final Vector2 velocity = new Vector2();
	
	//max velocity of koala on x-axis
	public final float MAX_VELOCITY = 10f;
	
	//initial state of koala is standing.
	private State state = State.Standing;

	//true if facing right, false if facing left
	private boolean direction = true;
	
	//state time is used to know how long the koala is performing an animation
	private float stateTime = 0;
	
	//true if koala is on the ground, false if in the air
	private boolean onGround = true;
	
	private Animation stand;		//stand animation
	private Animation walk;			//walk animation		
	private Animation jump;			//jump animation
	private Animation climb;		//climb animation
	
	public Koala() {
		
		//reading walk texture of Koala
		AssetManager assetManager = new AssetManager();
		assetManager.load("images/koala/walk.png",Texture.class);
		assetManager.finishLoading();
		Texture walkTexture = assetManager.get("images/koala/walk.png",Texture.class);
		
		//one frame is 100x100 pixels
		TextureRegion[] splitTexture = TextureRegion.split(walkTexture, 100, 100)[0];
		
		//setting stand animation to 1st frame in walk texture
		stand = new Animation(0, splitTexture[0]);
		
		//setting walk animation to 2nd, 3rd & 4th frame in walk texture
		walk = new Animation(0.3f, splitTexture[1], splitTexture[2], splitTexture[3]);
		walk.setPlayMode(Animation.LOOP_PINGPONG);
		
		//scale texture of koala to fit screen
		HEIGHT = Gdx.graphics.getHeight()/6;
		WIDTH = HEIGHT; // so that it turns to be a square
		
		//initial position of koala
		position.set(Gdx.graphics.getWidth()/2 - WIDTH, 0);
	}
	
	public void move(float deltaTime) {
		position.add(velocity);				//update position of koala
	}
	
	public void setState(State state) {
		this.state = state;					//set state of koala
	}
	
	public State getState() {
		return state;						//return state of koala
	}
	
	public float getStateTime() {
		return stateTime;					//return state time of koala
	}
	
	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;			//set state time of koala
	}
	
	public TextureRegion getStateFrame() {
		switch (state)						//depending on the state of the koala, return the frame of the animation at stateTime
		{
			case Standing:
				return stand.getKeyFrame(stateTime);
			case Walking:
				return walk.getKeyFrame(stateTime);
			case Jumping:
				return jump.getKeyFrame(stateTime);
			case Climbing:
				return climb.getKeyFrame(stateTime);
		}
		return null;
	}
	
	public boolean getDirection() {
		return direction;
	}
	
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	
	public boolean getOnGround() {
		return onGround;
	}
	
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}
	
	public float getWidth() {
		return WIDTH;
	}
	
	public float getHeight() {
		return HEIGHT;
	}
	
	public float getMaxVelocity() {
		return MAX_VELOCITY;
	}
}
