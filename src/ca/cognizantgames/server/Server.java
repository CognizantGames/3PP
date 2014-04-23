/**
 * This class is the graphical server for the game
 * mechanical part of the server check GameServer.java
 *
 * @author Demetry
 * 4222014
 */

//TODO: Make an server UI, make it start with a jFrame and work on that, have console, player list, etc!

package ca.cognizantgames.server;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;



public class Server implements Screen {
    Game game;

    String ip = "127.0.0.1";
    int port = 8080;

    GameServer server;

    BitmapFont font;
    SpriteBatch spriteBatch;

    public Server(Game game){
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), Color.BLACK.getAlpha());
        spriteBatch.begin();
            font.draw(spriteBatch, "Server", 512, 384);
        spriteBatch.end();
        tick(delta);
    }

    public void tick(float delta){

    }

    @Override
    public void resize(int x, int y) {

    }

    @Override
    public void show() {
        font = new BitmapFont();
        spriteBatch = new SpriteBatch();

        server = new GameServer(port, ip);
        server.startServer();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
