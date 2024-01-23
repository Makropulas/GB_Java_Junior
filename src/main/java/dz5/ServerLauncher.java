package dz5;

import dz5.server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerLauncher {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1111);
            Server server = new Server(serverSocket);
            server.runServer();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
