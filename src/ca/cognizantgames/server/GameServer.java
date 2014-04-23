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

    public GameServer(int port, String ip){
        this.port = port;
        this.ip = ip;
    }

    public void startServer(){
        server = new Server();

        Frame frame = new Frame();

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
                    Request request = (Request)object;
                    System.out.println(request.text);

                    Response response = new Response();
                    response.text = "Hello Client";
                    connection.sendTCP(response);
                }
            }
        });
    }

    public void stopServer(){
        server.stop();
    }
}
