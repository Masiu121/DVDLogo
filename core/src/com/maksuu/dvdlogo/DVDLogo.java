package com.maksuu.dvdlogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class DVDLogo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int x, y, xSpeed, ySpeed;
	int height, width;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("DVD_logo.png");
		height = Gdx.graphics.getBackBufferHeight();
		width = Gdx.graphics.getBackBufferWidth();
		xSpeed = -3;
		ySpeed = 3;
		x = 0;
		y = height - img.getHeight();
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}

	public void update() {
		if(x <= 0 || x >= width - img.getWidth()) {
			xSpeed = xSpeed * -1;
		}
		if(y <= 0 || y >= height - img.getHeight()) {
			ySpeed = ySpeed * -1;
		}
		x += xSpeed;
		y += ySpeed;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}