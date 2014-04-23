package ca.cognizantgames.game;


import ca.cognizantgames.screens.Splash;
import ca.cognizantgames.utilities.Logger;

import javax.swing.*;
import java.awt.*;

public class Game extends com.badlogic.gdx.Game{
    Frame frame;
    @Override
    public void create() {
        frame = new Frame();
        Logger logger = new Logger("log.txt");
        try{
            setScreen(new Splash(this));
        }catch(Exception e){
            e.printStackTrace();
            logger.Log(e.getMessage());
            JOptionPane.showMessageDialog(frame, "Whoops something went wrong please report the log!");
        }
    }
}
