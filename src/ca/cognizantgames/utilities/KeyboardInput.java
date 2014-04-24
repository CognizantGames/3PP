package ca.cognizantgames.utilities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyboardInput implements InputProcessor{

    public boolean S, W, ESC;
    @Override
    public boolean keyDown(int i) {
        if(i == Input.Keys.S){
            S = true;
            return true;
        }
        if(i == Input.Keys.W){
            W = true;
            return true;
        }
        if(i == Input.Keys.ESCAPE){
            ESC = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        if(i == Input.Keys.S){
            S = false;
            return true;
        }
        if(i == Input.Keys.W){
            W = false;
            return true;
        }
        if(i == Input.Keys.ESCAPE){
            ESC = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i2, int i3, int i4) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i2, int i3, int i4) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i2, int i3) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i2) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
