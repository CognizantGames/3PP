/**
 * This class is the graphical server for the game
 * mechanical part of the server check GameServer.java
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.server;

public class Response {
    public String id;
    public int x;
    public int y;
    public int score;
    public String text;

    public Response(){/*Unimplemented Constructor*/}
    public Response(String id){

    }
    public Response(String id, int x){

    }
    public Response(String id, int x, int y){

    }
    public Response(String id, int x, int y, int score){

    }
    public Response(String id, int x, int y, int score, String text){
        this.id = id;
        this.x = x;
        this.y = y;
        this.score = score;
        this.text = text;
    }
}
