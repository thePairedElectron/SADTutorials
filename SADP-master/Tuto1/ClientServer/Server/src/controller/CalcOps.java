package controller;

import businesslogic.SimpleCalc;

public class CalcOps {
    private SimpleCalc sCalc;

    public CalcOps() {
        sCalc = new SimpleCalc();
    }

    public float calc(String expr) {
        return sCalc.calculate(expr);
    }
}