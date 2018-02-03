package server;

import controller.CalcOps;

import java.io.*;
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

    public void runServer() throws IOException {
        try {
            socket = serverSocket.accept();

            System.out.println("Heard connection on port " + port);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String number = br.readLine();
            System.out.println("Message received from client is " + number);
            String returnMessage;
            try {
                CalcOps c = new CalcOps();
                float returnValue = c.calc(number);
                returnMessage = String.valueOf(returnValue) + "\n";
            } catch (NumberFormatException e) {
                returnMessage = "Please send a proper number\n";
            }
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(returnMessage);
            System.out.println("Message sent to the client is " + returnMessage);
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
            socket.close();
        }
    }

}

