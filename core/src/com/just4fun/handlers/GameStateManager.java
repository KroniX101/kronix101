package com.just4fun.handlers;

import com.just4fun.bbt.BallBounceTrap;
import com.just4fun.states.*;
import com.just4fun.constants.BBTConstants;

import java.util.Stack;

/**
 * Created by ChesterB on 3/4/2015.
 */
public class GameStateManager {

    private BallBounceTrap ballBounceTrapGame;

    private Stack<GameStates> gameStatesStack;

    public GameStateManager (BallBounceTrap _ballBounceTrap){

        this.ballBounceTrapGame = _ballBounceTrap;
        this.gameStatesStack = new Stack<GameStates>();
        pushGameState(BBTConstants.PLAY);
    }

    public BallBounceTrap ballBounceTrapGame(){
        return ballBounceTrapGame;
    }

    public void update(float _deltaTime){
        this.gameStatesStack.peek().update(_deltaTime);
    }

    public void render(){
        this.gameStatesStack.peek().render();
    }

    // helper function
    private GameStates getGameState(int _state){
        if(_state == BBTConstants.PLAY){
            // Case play, call play state
            return new PlayState(this);
        }
        return  null;
     }

    public void setGameState(int _state){
        popGameState();
        pushGameState(_state);
    }

    private void pushGameState(int _state){
        this.gameStatesStack.push(getGameState(_state));
    }

    private void popGameState(){
        GameStates _gameState = this.gameStatesStack.pop();
        _gameState.dispose();
    }
}
