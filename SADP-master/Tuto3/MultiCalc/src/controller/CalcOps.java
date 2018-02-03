package controller;

import businesslogic.ScientificCalc;

public class CalcOps {
    private ScientificCalc sCalc;

    public CalcOps() {
        sCalc = new ScientificCalc();
    }

    public float calc(String expr) {
        return sCalc.calculate(expr);
    }
}