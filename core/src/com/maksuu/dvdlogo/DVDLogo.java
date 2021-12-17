package com.maksuu.dvdlogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class DVDLogo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture whiteLogo;
	public static int height, width;
	Logo logo;

	@Override
	public void create() {
		batch = new SpriteBatch();
		whiteLogo = new Texture("DVD_logo.png");
		height = Gdx.graphics.getBackBufferHeight();
		width = Gdx.graphics.getBackBufferWidth();
		logo = new Logo(0, height - whiteLogo.getHeight(), whiteLogo, batch);
	}

	@Override
	public void render() {
		update();
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		logo.draw();
		batch.end();
	}

	public void update() {
		logo.update();
	}

	@Override
	public void dispose() {
		batch.dispose();
		logo.dispose();
		whiteLogo.dispose();
	}
}