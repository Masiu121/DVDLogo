package com.maksuu.dvdlogo;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.maksuu.dvdlogo.DVDLogo.height;
import static com.maksuu.dvdlogo.DVDLogo.width;

public class Logo {
    int x, y;
    int xSpeed, ySpeed;
    Texture texture;
    SpriteBatch batch;

    public Logo(int x, int y, Texture texture, SpriteBatch batch) {
        this.x = x;
        this.y = y;
        xSpeed = -20;
        ySpeed = 20;
        this.texture = texture;
        this.batch = batch;
    }

    public void draw() {
        batch.draw(texture, x, y);
    }

    public void update() {
        if (x <= 0) {
            batch.setColor(Color.PINK);
            xSpeed = xSpeed * -1;
        }
        if (x >= width - texture.getWidth()) {
            batch.setColor(Color.RED);
            xSpeed = xSpeed * -1;
        }
        if (y <= 0) {
            batch.setColor(Color.GREEN);
            ySpeed = ySpeed * -1;
        }
        if (y >= height - texture.getHeight()) {
            batch.setColor(Color.BLUE);
            ySpeed = ySpeed * -1;
        }
        x += xSpeed;
        y += ySpeed;
    }

    public void dispose() {
        texture.dispose();
    }
}
