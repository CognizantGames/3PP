package ca.cognizantgames.game;

import ca.cognizantgames.utilities.Logger;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final String GAME_NAME = "";

    public static void main(String[] args){
        Frame frame = new Frame();
        Logger logger = new Logger("log.txt");

        for (String arg : args) {
            if (arg.equals("-s")) {
                //start server
                break;
            } else if (arg.equals("-d")) {
                //debug
                break;
            } else if (arg.equals("-v")) {
                //verbose (log everything)
                logger.Log("Starting Verbose Mode");
                break;
            }
        }
        try{
            LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
            cfg.title = GAME_NAME;
            cfg.useGL20 = true;
            cfg.width = 1024;
            cfg.height = 768;
            cfg.addIcon("Assets/Icons/icon.png", Files.FileType.Internal);
            new LwjglApplication(new Game(), cfg);
            System.out.println("Game initialized correctly");
        }catch(Exception e){
            e.printStackTrace();
            logger.Log(e.getMessage());
            JOptionPane.showMessageDialog(frame, "Whoops something went wrong, please report the log file!");

        }
    }
}
