package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;
    private ServerSocket serverSocket;
    private int port;

    public Server(int port) {
        try {
            this.port = port;
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runServer() {
        try {
            socket = serverSocket.accept();
            new ServerThread(socket).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

