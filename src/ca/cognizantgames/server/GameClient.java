/**
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.server;

import ca.cognizantgames.game.Main;
import ca.cognizantgames.game.Player;
import ca.cognizantgames.game.UserInput;
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

import java.io.IOException;

public class GameClient implements Screen {
    Game game;

    Client client;

    String ip = "127.0.0.1";
    int port = 8080;
    long id;
    Request request;

    UserInput input;

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
        player1.setPosition(new Vector2(1000, 384));
        player2.setPosition(new Vector2(502, 394));

        spriteBatch.begin();
            background.draw(spriteBatch);
            background.setPosition(1,1);

            paddle.draw(spriteBatch);
            paddle.setPosition(player.getPostion().x, player.getPostion().y);

            paddle2.draw(spriteBatch);
            paddle2.setPosition(player1.getPostion().x, player1.getPostion().y);

            packman.draw(spriteBatch);
            packman.setPosition(player2.getPostion().x, player2.getPostion().y);
        spriteBatch.end();

        tick(delta);
    }

    public void tick(float delta){


        //System.out.println("Player: "+player.getName()+" Player1: "+player1.getName()+" Player2: "+player2.getName());
    }

    @Override
    public void resize(int x, int y) {

    }

    @Override
    public void show() {
        input = new UserInput();

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

        request = new Request();
        request.name = player.getName();
        request.text = "Connect";
        client.sendTCP(request);

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Response) {
                    Response response = (Response) object;
                    if(response.text.equals("ID")){
                        id = response.id;
                        System.out.println(id);
                    }
                }
            }
        });
    }

    public void getAssets(){
        //load all the assets here
        player = new Player();
        player.setName(Main.name);
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
