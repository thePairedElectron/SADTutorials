package businesslogic;

public class ScientificCalc extends SimpleCalc implements CalcInterface, SciMathInterface {

    public float sin(float a) {
        return (float) Math.sin(a);
    }

    public float cos(float a) {
        return (float) Math.cos(a);
    }

    public float tan(float a) {
        return (float) Math.tan(a);
    }

    public float toRadian(float c) {
        return (float) Math.toRadians(c);
    }

    @Override
    public boolean isOp(String op) {
        return op.equals("sin") || op.equals("cos") || op.equals("tan");
    }

    @Override
    public int priority(String c) {
        switch (c) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            case "sin":
            case "cos":
            case "tan":
                return 2;
            default:
                return -1;
        }
    }

    public boolean isChar(String a) {
        char c = a.charAt(0);
        return 0 <= (c - 'a') && 25 >= (c - 'a');
    }

    public float unaryOperation(String op) {
        float a = toRadian(stnum.pop());
        switch (op) {
            case "sin":
                return sin(a);
            case "cos":
                return cos(a);
            case "tan":
                return tan(a);
        }
        return 0;
    }

    private boolean decideOp(String c) {
        if (c.equals("("))
            return true;
        else if (super.isOp(c)) {
            stnum.push(binaryOperation(c));
        } else if (isOp(c)) {
            stnum.push(unaryOperation(c));
        }
        return false;
    }

    public float calculate(String expr) {
        String num = "";
        String operation = "";
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
            } else if (isChar(c)) {
                operation += c;
                if (!isChar(d)) {
                    stchar.push(operation);
                    operation = "";
                }

            } else if (super.isOp(c)) {
                while (true) {
                    String top;
                    if (!stchar.empty())
                        top = stchar.peek();
                    else
                        top = "\0";
                    if (super.isOp(top) || isOp(top)) {
                        if (!(priority(c) > priority(top))) {
                            stchar.pop();
                            if (super.isOp(top)) {
                                stnum.push(binaryOperation(top));
                            } else if (isOp(top)) {
                                stnum.push(unaryOperation(top));
                            }
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
                    if (decideOp(c)) break;
                }
            }

        }
        while (!stchar.empty()) {
            String c = stchar.pop();
            if (decideOp(c)) break;
        }
        return stnum.pop();
    }

}
