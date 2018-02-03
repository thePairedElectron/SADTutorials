package main;

import ui.CalcUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CalcUI c = new CalcUI("localhost",2000);
        c.runUI();
    }
}
