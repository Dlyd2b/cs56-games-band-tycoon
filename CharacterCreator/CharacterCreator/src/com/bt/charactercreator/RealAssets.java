package com.bt.charactercreator;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class RealAssets extends AssetManager{
	GameplayScreen gs;
	
	public RealAssets(GameplayScreen gs){
		super();
		this.gs = gs;
	}
	
	public void load(){
		super.load("data/window.png", Texture.class);
		super.load("data/widegrayborder.png", Texture.class);
		super.load("data/tinybox.png", Texture.class);
		super.load("data/sliderknob-s.png", Texture.class);
		super.load("data/sliderknob-m.png", Texture.class);
		super.load("data/white.png", Texture.class);		
		super.load("data/white-s.png", Texture.class);
		super.load("data/white-m.png", Texture.class);
	}
	
}
