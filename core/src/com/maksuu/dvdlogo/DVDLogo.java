package com.maksuu.dvdlogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class DVDLogo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture pink;
	Texture green;
	Texture red;
	Texture violet;
	Texture mainTexture;
	int x, y, xSpeed, ySpeed;
	int height, width;

	@Override
	public void create () {
		batch = new SpriteBatch();
		pink = new Texture("DVD_logo_pink.png");
		green = new Texture("DVD_logo_green.png");
		red = new Texture("DVD_logo_red.png");
		violet = new Texture("DVD_logo_violet.png");
		height = Gdx.graphics.getBackBufferHeight();
		width = Gdx.graphics.getBackBufferWidth();
		xSpeed = -3;
		ySpeed = 3;
		x = 0;
		y = height - pink.getHeight();

		mainTexture = pink;
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(mainTexture, x, y);
		batch.end();
	}

	public void update() {
		if(x <= 0) {
			mainTexture = pink;
			xSpeed = xSpeed * -1;
		}
		if(x >= width - pink.getWidth()) {
			mainTexture = green;
			xSpeed = xSpeed * -1;
		}
		if(y <= 0) {
			mainTexture = violet;
			ySpeed = ySpeed * -1;
		}
		if(y >= height - pink.getHeight()) {
			mainTexture = red;
			ySpeed = ySpeed * -1;
		}
		x += xSpeed;
		y += ySpeed;
	}

	@Override
	public void dispose () {
		batch.dispose();
		red.dispose();
		pink.dispose();
		violet.dispose();
		green.dispose();
	}
}