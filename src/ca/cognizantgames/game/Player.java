package ca.cognizantgames.game;

import com.badlogic.gdx.math.Vector2;

public class Player {

    String name;
    Vector2 position;
    int id;

    public Player(){

    }
    public Player(String name){

    }
    public Player(String name, int id){

    }
    public Player(String name, Vector2 position){

    }
    public Player(String name, int id, Vector2 position){
        this.position = position;
        this.name = name;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }

    public void setPostion(int x, int y){
        this.position = new Vector2(x, y);
    }

    public Vector2 getPostion(){
        return this.position;
    }

    public float getPlayerX(){
        return this.position.x;
    }

    public float getPlayerY(){
        return this.position.y;
    }
}
