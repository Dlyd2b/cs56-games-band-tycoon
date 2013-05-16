package ucsb.cs56.projects.games.band_tycoon.character_creator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;

public class Main {
	public static void main(String[] args) {
		Texture.setEnforcePotImages(false); //No longer crashes when an image isn't a power of 2
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Character Creator";
		cfg.useGL20 = false;
		cfg.width = 480;
		cfg.height = 800;
		
		new LwjglApplication(new CharacterCreator(), cfg);
	}
}
