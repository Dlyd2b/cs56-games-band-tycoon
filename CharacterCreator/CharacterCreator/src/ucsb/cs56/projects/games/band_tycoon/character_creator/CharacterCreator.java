package ucsb.cs56.projects.games.band_tycoon.character_creator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;

public class CharacterCreator extends Game implements ApplicationListener {
	//GameplayScreen gameplayScreen;
	//MainMenuScreen mainMenuScreen;
	float width;
	float height;
	public boolean gameplayScreenLoaded=false;
	@Override
	public void create() {		
		//mainMenuScreen = new MainMenuScreen(this);
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		//setScreen(mainMenuScreen);
		//gameplayScreen = new GameplayScreen(this);
		//mainMenuScreen.setGameplayScreen(gameplayScreen);		
	}
}