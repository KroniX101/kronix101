package com.just4fun.constants;

import com.badlogic.gdx.Gdx;

/**
 * Created by ChesterB on 3/4/2015.
 */
public final class BBTConstants {

    // Game Title
    public static final String GAME_TITLE = "Bounce Bounce";

    // Dimensions
    public static final float DIM_WIDTH =  Gdx.graphics.getWidth();
    public static final float DIM_HEIGHT = Gdx.graphics.getHeight();

    // States
    public static final int PLAY = 98765;

    // FPS
    public  static final float FPS = 1/60f;

    // The standard conversion for objects using meters is this
    public static final float BOX2D_PPM = 100; // This means 100 pixels/meter

}
