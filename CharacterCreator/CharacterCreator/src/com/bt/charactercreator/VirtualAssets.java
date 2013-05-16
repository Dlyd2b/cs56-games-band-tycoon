package com.bt.charactercreator;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class VirtualAssets extends AssetManager{
	GameplayScreen gs;
	
	public VirtualAssets(GameplayScreen gs) {
		super();
		this.gs = gs;
	}

	public void load() {
		super.load("data/fieldbackground.jpg", Texture.class);
		super.load("data/circle-red.png", Texture.class);
		super.load("data/circle-blue.png", Texture.class);
		super.load("data/circle-green.png", Texture.class);
		super.load("data/circle-yellow.png", Texture.class);
	}
}
