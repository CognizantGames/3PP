package ca.cognizantgames.utilities;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Logger {
    BufferedWriter writer;
    Frame frame;

    public Logger(String filename){
        frame = new Frame();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../" + filename)));
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, "Logger failed to initialize");
        }finally {
            try{writer.close();}catch (Exception e){e.printStackTrace();}
        }
    }
    public void Log(String message){
        frame = new Frame();
        try{
            writer.write(message);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to write to log file!");
        }finally {
            try{writer.close();}catch (Exception e){e.printStackTrace();}
        }
    }
    public void Close(){
        try{
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
