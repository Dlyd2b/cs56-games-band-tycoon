package ucsb.cs56.projects.games.band_tycoon.character_creator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Music;

public class GameplayScreen extends GameScreen{
	public static boolean isPaused = false;

	private ShapeRenderer letterbox;
	public float time = 0;
	public InputMultiplexer inputMultiplexer;
	
	public Stage characterCreationStage;
	
	public static VirtualAssets virtualAssets;
	public static RealAssets realAssets;
	public ArrayList<Character> characters;
	public Character c1;
	public Character c2;
	public Character c3;
	public Character c4;
	public Character c5;
	
	public BitmapFont font, headerFont, font3, font4;
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.:;,{}\"´`'<>";		

	public FreeTypeFontGenerator generator;
	public SpriteBatch batch;
	
	public GameplayScreen(Game game){
		super(game);
		
		//Load assets
		virtualAssets = new VirtualAssets(this);
		virtualAssets.load();
		virtualAssets.finishLoading();
		realAssets = new RealAssets(this);
		realAssets.load();
		realAssets.finishLoading();
		
		batch = new SpriteBatch();
		

		//Primitive letterbox
		letterbox = new ShapeRenderer();
		letterbox.setColor(Color.BLACK);
		
		//Stage creation
		characterCreationStage = new Stage();
		
		//Character initialization
		characters = new ArrayList<Character>();
		c1 = new Character("Jane", Character.FEMALE);
		c2 = new Character("Suzie", Character.FEMALE);
		c3 = new Character("Sunny", Character.FEMALE);
		c4 = new Character("Joe", Character.MALE);
		c5 = new Character("John", Character.MALE);
		
		//Must call this function to initialize characters
		initializeCharacters(c1,c2,c3,c4,c5);
		
		//Input initialization
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(characterCreationStage);
		Gdx.input.setInputProcessor(inputMultiplexer);
	}
	
	public void createButtons(){

	}
	
	@Override
	public void dispose() {
		letterbox.dispose();
		characterCreationStage.dispose();
	}
	
	@Override
	public void resize(int width, int height){
		super.resize(width, height);
        characterCreationStage.setViewport(width, height, true);
		//ui.resize(width, height);
	}
	
	@Override
	public void render(float delta) {
		//Clears color buffer
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		characterCreationStage.getCamera().update();
		
		//Updates and draws everything
		update(delta);
		characterCreationStage.draw();
		draw(delta);
	}
	
	@Override
	public void update(float delta){
		//ui.update(delta);
		characterCreationStage.act(delta);
	}
	
	@Override
	public void draw(float delta){
		//Primitive letterboxing
		letterbox.setProjectionMatrix(characterCreationStage.getCamera().combined);
		if(aspectRatio > ASPECT_RATIO){
			letterbox.begin(ShapeType.Filled);
			letterbox.rect(REAL_WIDTH - (REAL_WIDTH - SCALED_WIDTH)/2, 0, (REAL_WIDTH - SCALED_WIDTH)/2, REAL_HEIGHT);
			letterbox.end();
		}
		else if (aspectRatio < ASPECT_RATIO){
			letterbox.begin(ShapeType.Filled);
			letterbox.rect(0, REAL_HEIGHT - (REAL_HEIGHT - SCALED_HEIGHT)/2 , REAL_WIDTH, (REAL_HEIGHT - SCALED_HEIGHT)/2);
			letterbox.end();
		}
	}
	public void initializeCharacters(Character ...chars){
		for (Character c:chars){
			characters.add(c);
		}
	}
	
	@Override
	public void show(){
	}
	
}
