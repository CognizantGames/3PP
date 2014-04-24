/**
 * This class is the graphical server for the game
 * mechanical part of the server check GameServer.java
 *
 * @author Demetry
 * 4222014
 */
//TODO: Make a proper menu, not just click and right click!
package ca.cognizantgames.screens;


import ca.cognizantgames.server.GameClient;
import ca.cognizantgames.server.Server;
import ca.cognizantgames.utilities.Button;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu implements Screen {
    Game game;
    SpriteBatch spriteBatch;

    Sprite background, ball, _play, play;

    Button playButton;

    public Menu(Game game){
        this.game = game;
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
            background.draw(spriteBatch);
            background.setPosition(0, 0);

            _play.draw(spriteBatch);
            _play.setPosition(24, 335);
        spriteBatch.end();

        if(playButton.isMouseOver(Gdx.input.getX(), Gdx.input.getY(), Gdx.graphics.getHeight())){
            _play.setColor(Color.RED);
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                game.setScreen(new GameClient(game));
            }else if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
                game.setScreen(new Server(game));
            }
        }else{
            _play.setColor(Color.WHITE);
        }
    }

    @Override
    public void resize(int x, int y) {
        //resize the view port accordingly
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();

        background = new Sprite(new Texture(Gdx.files.internal("Assets/Images/menuback.png")));

        _play = new Sprite(new Texture(Gdx.files.internal("Assets/Images/playbutton.png")));
        playButton = new Button(24, 335, (int) _play.getWidth(), (int) _play.getHeight()); //to be refined to location

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
