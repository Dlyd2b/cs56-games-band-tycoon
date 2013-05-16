package ucsb.cs56.projects.games.band_tycoon.character_creator;

import ucsb.cs56.projects.games.band_tycoon.character_creator.CharacterCreator;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Texture.setEnforcePotImages(false); //No longer crashes when an image isn't a power of 2

        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        initialize(new CharacterCreator(), cfg);
    }
}