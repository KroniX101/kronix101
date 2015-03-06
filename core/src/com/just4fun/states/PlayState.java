package com.just4fun.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.just4fun.constants.BBTConstants;
import com.just4fun.handlers.GameStateManager;

import java.awt.Polygon;

/**
 * Created by ChesterB on 3/4/2015.
 */
public class PlayState extends GameStates {

    // Test
    private BitmapFont font = new BitmapFont();

    private World gameWorld;

    private Box2DDebugRenderer b2dDbg;

    private BodyDef bodyDef;
    private Body body;
    private FixtureDef fixtureDef;

    private OrthographicCamera orthoBox2DCam;

    public PlayState(GameStateManager _gameStateMgr){
        super(_gameStateMgr);

        // Create World
        this.gameWorld = new World(new Vector2(0, -9.81f), true);
        this.b2dDbg = new Box2DDebugRenderer();

        //Create a platform
        this.createPlatForm();
    }

    public void handleInput(){

    }
    public  void update(float _deltaTime){
        this.gameWorld.step(BBTConstants.FPS,6,2);
    }
    public void render(){
        // Clear the screen
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render world
        this.b2dDbg.render(this.gameWorld, this.orthoBox2DCam.combined);
        /*
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();
        font.draw(spriteBatch, "Playing", 100,100);
        spriteBatch.end();
        */
    }
    public void dispose(){
        // Clean all trashes
        spriteBatch.dispose();
        font.dispose();
        this.gameWorld.dispose();
        this.b2dDbg.dispose();
    }

    private void createPlatForm(){

        bodyDef = new BodyDef();
        //Set position
        bodyDef.position.set((BBTConstants.DIM_WIDTH / 2)  / BBTConstants.BOX2D_PPM, 200 / BBTConstants.BOX2D_PPM);
        bodyDef.type = BodyType.StaticBody;

        // Create Body base on definition
        body = this.gameWorld.createBody(bodyDef);//.createFixture("IDD_BOX");

        // Create shape - This is dummy
        PolygonShape polyShape = new PolygonShape();
        polyShape.setAsBox(50  / BBTConstants.BOX2D_PPM, 5  / BBTConstants.BOX2D_PPM);

        // Define Fixture
        fixtureDef = new FixtureDef();
        fixtureDef.shape = polyShape;
        this.body.createFixture(fixtureDef);

        // CREATE ANOTHER BOX - TEST
        bodyDef.position.set((BBTConstants.DIM_WIDTH / 2) / BBTConstants.BOX2D_PPM, (BBTConstants.DIM_HEIGHT / 2)  / BBTConstants.BOX2D_PPM);
        bodyDef.type = BodyType.DynamicBody;
        body = gameWorld.createBody(bodyDef);

        polyShape.setAsBox(5  / BBTConstants.BOX2D_PPM ,5  / BBTConstants.BOX2D_PPM);
        fixtureDef.shape = polyShape;
        fixtureDef.restitution = 1.0f;
        body.createFixture(fixtureDef);

        orthoBox2DCam = new OrthographicCamera();
        orthoBox2DCam.setToOrtho(false, BBTConstants.DIM_WIDTH / BBTConstants.BOX2D_PPM, BBTConstants.DIM_HEIGHT / BBTConstants.BOX2D_PPM);
    };

}
