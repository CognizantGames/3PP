/**
 * This class is the graphical server for the game
 * mechanical part of the server check GameServer.java
 *
 * @author Demetry
 * 4222014
 */

package ca.cognizantgames.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import javax.swing.*;
import java.awt.*;

public class GameServer {
    String ip;
    int port;

    Server server;

    Response response;

    String[] names;
    long[] ids;

    public static final int MAX_CONNECTIONS = 3;

    public GameServer(int port, String ip){
        this.port = port;
        this.ip = ip;
    }

    public void startServer(){
        server = new Server();

        Frame frame = new Frame();

        names = new String[MAX_CONNECTIONS];
        ids = new long[MAX_CONNECTIONS];

        server.start();

        try {
            server.bind(port);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Could not bind "+port);
        }

        Kryo kryo = server.getKryo();
        kryo.register(Request.class);
        kryo.register(Response.class);

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                //responses go here from server!
                if (object instanceof Request) {
                    Request request = (Request) object;
                    if(request.text.equals("Connect")) {
                        //Assign each client an id, get a name for that id then return the other names to the clients
                        System.out.println(connection.getID());

                        response = new Response();
                        response.id = connection.getID();
                        response.text = "ID";
                        connection.sendTCP(response);
                    }
                }
                Connection[] connections;
                connections = server.getConnections();
                for(int i = 0; i < server.getConnections().length; i++){
                    if(!connections[i].isConnected()){
                        connections[i].close();
                    }
                }
            }
        });
    }

    public void stopServer(){
        server.stop();
    }
}
