/**
 * This class is the graphical server for the game
 * mechanical part of the server check GameServer.java
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.server;

public class Request {
    public String id;
    public int x;
    public int y;
    public int score;
    public String text;

    public Request(){/*Unimplemented Constructor*/}
    public Request(String id){

    }
    public Request(String id, int x){

    }
    public Request(String id, int x, int y){

    }
    public Request(String id, int x, int y, int score){

    }
    public Request(String id, int x, int y, int score, String text){
        this.id = id;
        this.x = x;
        this.y = y;
        this.score = score;
        this.text = text;
    }
}
