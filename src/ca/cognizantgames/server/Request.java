/**
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.server;

public class Request {
    public String name;
    public long id;
    public int x;
    public int y;
    public int score;
    public String text;

    public Request(){/*Unimplemented Constructor*/}
    public Request(String name){
        this.name = name;
    }
    public Request(String name, long id){
        this.name = name;
        this.id = id;
    }
    public Request(String name, int x){
        this.name = name;
        this.x = x;
    }
    public Request(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public Request(String name, int x, int y, int score){
        this.name = name;
        this.x = x;
        this.y = y;
        this.score = score;
    }
    public Request(String name, int x, int y, int score, String text){
        this.name = name;
        this.x = x;
        this.y = y;
        this.score = score;
        this.text = text;
    }
}
