/**
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.server;

public class Response {
    public String name;
    public long id;
    public int x;
    public int y;
    public int score;
    public String text;

    public Response(){/*Unimplemented Constructor*/}
    public Response(String name){
        this.name = name;
    }
    public Response(String name, long id){
        this.name = name;
        this.id = id;
    }
    public Response(String name, int x){
        this.name = name;
        this.x = x;
    }
    public Response(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public Response(String name, int x, int y, int score){
        this.name = name;
        this.x = x;
        this.y = y;
        this.score = score;
    }
    public Response(String name, int x, int y, int score, String text){
        this.name = name;
        this.x = x;
        this.y = y;
        this.score = score;
        this.text = text;
    }
}
