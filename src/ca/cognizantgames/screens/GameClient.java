/**
 * This class is the graphical server for the game
 * mechanical part of the server check GameServer.java
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.screens;

import ca.cognizantgames.game.Player;
import ca.cognizantgames.server.Request;
import ca.cognizantgames.server.Response;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import javax.swing.*;
import java.io.IOException;

public class GameClient implements Screen {
    Game game;

    Client client;

    String ip = "127.0.0.1";
    int port = 8080;


    Player player, player1, player2;
    String name, playerOneName, playerTwoName;

    SpriteBatch spriteBatch;
    BitmapFont font;

    Sprite paddle, paddle2;
    Sprite background;
    Sprite ball;
    Sprite packman; //Could be copyright? Spelt incorrectly for reason.

    public GameClient(Game game){
        this.game = game;
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.setPosition(new Vector2(24, 384));

        spriteBatch.begin();
            background.draw(spriteBatch);
            background.setPosition(1,1);
            paddle.draw(spriteBatch);
            paddle.setPosition(player.getPostion().x, player.getPostion().y);
        spriteBatch.end();

        Request request = new Request();
        request.id = name;
        request.text = "Hello Server!";
        //client.sendTCP(request);
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

        try {
            getAssets();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-4);
        }

        client = new Client();
        client.start();

        try {
            client.connect(4000, ip, port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-5);
        }

        Kryo kryo = client.getKryo();
        kryo.register(Request.class);
        kryo.register(Response.class);

        client.sendTCP(new Request(player.getName()));

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Response) {
                    Response response = (Response) object;
                    //System.out.println(response.text);
                }
            }
        });
    }

    public void getAssets(){
        //load all the assets here
        JOptionPane.showInputDialog(name);
        player = new Player();
        player.setName(name);
        player1 = new Player();
        player2 = new Player();
        paddle = new Sprite(new Texture(Gdx.files.internal("Assets/Images/paddle.png")));
        paddle2 = new Sprite(new Texture(Gdx.files.internal("Assets/Images/paddle.png")));
        background = new Sprite(new Texture(Gdx.files.internal("Assets/Images/background.png")));
        ball = new Sprite(new Texture(Gdx.files.internal("Assets/Images/ball.png")));
        packman = new Sprite(new Texture(Gdx.files.internal("Assets/Images/packman.png")));
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
