package businesslogic;

import java.util.Stack;

public class SimpleCalc implements CalcInterface, BasicMathInterface {
    protected Stack<Float> stnum = new Stack<>();
    protected Stack<String> stchar = new Stack<>();

    public float add(float a, float b) {
        return a + b;
    }

    public float sub(float a, float b) {
        return a - b;
    }

    public float mul(float a, float b) {
        return a * b;
    }

    public float div(float a, float b) {
        return a / b;
    }

    public int priority(String c) {
        switch (c) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            default:
                return -1;
        }
    }

    public boolean isNum(String a) {
        char c = a.charAt(0);
        return (c - '0') >= 0 && (c - '0') < 10;
    }

    public boolean isOp(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }


    public float choose(String c, float num1, float num2) {
        switch (c) {
            case "+":
                return (add(num1, num2));
            case "*":
                return (mul(num1, num2));
            case "/":
                return (div(num1, num2));
            case "-":
                return (sub(num1, num2));
            default:
                return -1;
        }
    }

    protected float binaryOperation(String op) {
        float b = stnum.pop();
        float a = stnum.pop();
        return (choose(op, a, b));

    }

    public float calculate(String expr) {
        String num = "";
        for (int i = 0; i < expr.length(); i++) {
            String c = Character.toString(expr.charAt(i));
            String d;

            if (i + 1 < expr.length())
                d = Character.toString(expr.charAt(i + 1));
            else
                d = "\0";
            if (isNum(c)) {
                num += c;
                if (!isNum(d)) {
                    stnum.push(Float.parseFloat(num));
                    num = "";
                }
            } else if (isOp(c)) {
                while (true) {
                    String top;
                    if (!stchar.empty())
                        top = stchar.peek();
                    else
                        top = "\0";
                    if (isOp(top)) {
                        if (!(priority(c) > priority(top))) {
                            String op = stchar.pop();
                            stnum.push(binaryOperation(op));

                        } else {
                            stchar.push(c);
                            break;
                        }
                    } else {
                        stchar.push(c);
                        break;
                    }
                }
            } else if (c.equals("("))
                stchar.push(c);
            else if (c.equals(")")) {
                while (!stchar.empty()) {
                    c = stchar.pop();
                    if (c.equals("("))
                        break;
                    else if (isOp(c)) {
                        stnum.push(binaryOperation(c));
                    }
                }
            }

        }
        while (!stchar.empty()) {
            String c = stchar.pop();
            if (c.equals("("))
                break;
            else if (isOp(c)) {
                stnum.push(binaryOperation(c));
            }
        }
        return stnum.pop();
    }

}
