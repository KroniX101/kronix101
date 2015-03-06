package com.just4fun.bbt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.just4fun.handlers.GameStateManager;
import com.just4fun.constants.*;

public class BallBounceTrap extends ApplicationAdapter {

    private GameStateManager gameStateManager;
    private SpriteBatch spriteBatch;
    private OrthographicCamera orthographicCamera;
    private OrthographicCamera orthographicCameraHUD;

    private float accumulator = 0.0f;

	@Override
	public void create () {
        this.spriteBatch = new SpriteBatch();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.orthographicCameraHUD = new OrthographicCamera();
        this.orthographicCameraHUD.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.gameStateManager = new GameStateManager(this);
	}

	@Override
	public void render () {
        this.accumulator += Gdx.graphics.getDeltaTime();
        while(this.accumulator >= BBTConstants.FPS){
            this.accumulator -= BBTConstants.FPS;
            this.gameStateManager.update(BBTConstants.FPS);
            this.gameStateManager.render();
        }
	}

    @Override
    public void dispose(){
        this.spriteBatch.dispose();
    }

    @Override
    public  void resume(){
    }

    @Override
    public void pause(){
    }

    @Override
    public void resize(int width, int height){}

    public  SpriteBatch getSpriteBatch(){
        return spriteBatch;
    }

    public OrthographicCamera getOrthographicCamera(){
        return orthographicCamera;
    }

    public OrthographicCamera getOrthographicCameraHUD(){
        return orthographicCameraHUD;
    }
}
