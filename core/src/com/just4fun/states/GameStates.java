package com.just4fun.states;

import com.just4fun.handlers.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.just4fun.bbt.BallBounceTrap;

/**
 * Created by ChesterB on 3/4/2015.
 */
public abstract class GameStates {

    protected GameStateManager gameStateMgr;
    protected BallBounceTrap ballBounceTrap;
    protected SpriteBatch spriteBatch;
    protected OrthographicCamera orthographicCamera;
    protected OrthographicCamera orthographicCameraHUD;

    protected  GameStates(GameStateManager _gameStateMgr){
        this.gameStateMgr = _gameStateMgr;
        this.ballBounceTrap =  this.gameStateMgr.ballBounceTrapGame();
        this.spriteBatch = this.ballBounceTrap.getSpriteBatch();
        this.orthographicCamera = this.ballBounceTrap.getOrthographicCamera();
        this.orthographicCameraHUD = this.ballBounceTrap.getOrthographicCameraHUD();
    }

    public abstract void handleInput();
    public abstract  void update(float _deltaTime);
    public abstract void render();
    public abstract void dispose();
}


