package server;

import controller.CalcOps;

import java.io.*;
import java.net.Socket;

public class ServerThread  extends Thread{
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            System.out.println("Heard connection");
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
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
