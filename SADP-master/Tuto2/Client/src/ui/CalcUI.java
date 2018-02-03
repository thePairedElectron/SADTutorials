package ui;
import uicontroller.SocketManager;

import java.util.Scanner;

public class CalcUI {
    private SocketManager manager;

    public CalcUI(String host, int port) {
        manager = new SocketManager(host, port);
    }

    public void runUI() {
        System.out.println("Enter Expression :");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String expr = sc.nextLine();
            try {
                String result = manager.work(expr);

                System.out.println("Response :" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
