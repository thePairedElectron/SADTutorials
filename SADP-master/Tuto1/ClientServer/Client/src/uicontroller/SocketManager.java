package uicontroller;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class SocketManager {
    private Socket socket;
    private String host;
    private int port;

    public SocketManager(String host, int port){
        this.host = host;
        this.port = port;
    }
    public String work(String expr) throws IOException {
        try
        {
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            String sendMessage = expr + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : " + sendMessage);

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return "";
    }

}
