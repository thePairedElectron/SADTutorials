package ui;


import controller.CalcOps;

import java.util.Scanner;

public class CalcUI {

    public void runUI() {
        System.out.println("Enter Expression :");
        Scanner sc = new Scanner(System.in);
        CalcOps c = new CalcOps();
        while (true) {
            String expr = sc.next();
            System.out.println(c.calc(expr));
        }
    }
}
