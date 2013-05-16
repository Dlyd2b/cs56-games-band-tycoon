package ucsb.cs56.projects.games.band_tycoon.character_creator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public abstract class GameScreen implements Screen {
	Game game;
	
	protected static final int VIRTUAL_WIDTH = 480;
	protected static final int VIRTUAL_HEIGHT = 800;
    protected static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
    protected static int REAL_WIDTH = Gdx.graphics.getWidth();
    protected static int REAL_HEIGHT = Gdx.graphics.getHeight();
	protected static float SCALED_WIDTH = VIRTUAL_WIDTH;
	protected static float SCALED_HEIGHT = VIRTUAL_HEIGHT;
    protected float aspectRatio; //Real aspect ratio
    public OrthographicCamera virtualCam;
    public OrthographicCamera realCam;
    public Rectangle viewport;
	
	public GameScreen(Game game) {
		this.game = game;
	}
	
	public void update(float delta) {
	}

	public void draw(float delta){
	}
	
	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
        // calculate new viewport
		REAL_WIDTH = width;
		REAL_HEIGHT = height;
		
        aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        if(aspectRatio > ASPECT_RATIO)
        {
            scale = (float)height/(float)VIRTUAL_HEIGHT;
            crop.x = (width - VIRTUAL_WIDTH*scale)/2f;
        }
        else if(aspectRatio < ASPECT_RATIO)
        {
            scale = (float)width/(float)VIRTUAL_WIDTH;
            crop.y = (height - VIRTUAL_HEIGHT*scale)/2f;
        }
        else
        {
            scale = (float)width/(float)VIRTUAL_WIDTH;
        }
        SCALED_WIDTH = (float)VIRTUAL_WIDTH*scale;
        SCALED_HEIGHT = (float)VIRTUAL_HEIGHT*scale;
        viewport = new Rectangle(crop.x, crop.y, SCALED_WIDTH, SCALED_HEIGHT);
        
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
	
	
}
