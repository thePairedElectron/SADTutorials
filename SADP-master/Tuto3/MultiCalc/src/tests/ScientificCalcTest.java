package tests;

import businesslogic.ScientificCalc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScientificCalcTest {

    private float delta = (float) 0.0000002;
    private ScientificCalc bl;

    @org.junit.Before
    public void setUp()  {
        bl = new ScientificCalc();
    }

    @Test
    public void test1() {
        float actual = bl.calculate("tan(45)");
        float expected = 1.0f;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test2() {
        float actual = bl.calculate("1 - 2 * tan(45)");
        float expected = (float) -1;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test3() {
        float actual = bl.calculate("1 * 2 * sin(30)");
        float expected = (float) 1;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test4() {
        float actual = bl.calculate("1 / 2 * cos(60)");
        float expected = (float) 0.25;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test5() {
        float actual = bl.calculate("(2 + 3 * 4)+tan(45)");
        float expected = (float) 15;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test6() {
        float actual = bl.calculate("(2 + 3 - 4)+tan(50-5)");
        float expected = (float) 2;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test7() {
        float actual = bl.calculate("(2 + 3 / 4)+sin(25+5)");
        float expected = (float) 3.25;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test8() {
        float actual = bl.calculate("(2 + 3 * 4 / 5)-cos(30*2)");
        float expected = (float) 3.9;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test9() {
        float actual = bl.calculate("(2 + 3 * 4 - 5)-sin(45)+cos(50-5)");
        float expected = (float) 9;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test10() {
        float actual = bl.calculate("( 2 + 3 ) * 5 * tan(15*3)");
        float expected = (float) 25.0;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test11() {
        float actual = bl.calculate("sin(45) * cos(45)");
        float expected = (float) 0.5;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test12() {
        float actual = bl.calculate("( 2 * 3 ) / 5 * tan(9*5)");
        float expected = (float) 1.2;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test13() {
        float actual = bl.calculate("( 2 + 3 ) / ( 2 - 3 ) * sin(45) * cos(45) ");
        float expected = (float) -2.5;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test14() {
        float actual = bl.calculate("( 2 * 3 ) + ( 2 / 5 )-(sin(30)* cos(60))");
        float expected = (float) 6.15;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test15() {
        float actual = bl.calculate("( 2 * 6 ) + ( 2 / 5 )-(sin(30*4-80+5) * cos(30*4-80+5))");
        float expected = (float) 11.9;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test16() {
        float actual = bl.calculate("( 2 * 6 ) + ( 2 / 5 )-(2/4)+tan(45)");
        float expected = (float) 12.9;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test17() {
        float actual = bl.calculate("( 2 * 6 ) + ( 2 / 5 )-(40)+sin(30)-cos(60)+tan(45)");
        float expected = (float) -26.6;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test18() {
        float actual = bl.calculate("4 / 0 * 5 * sin(30)");
        float expected = Float.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test19() {
        float actual = bl.calculate("2+3*5-5/0 * sin(60)");
        float expected = Float.NEGATIVE_INFINITY;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test20() {
        float actual = bl.calculate("2*3/5*tan(30+3*5)");
        float expected = (float) 1.2;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test21() {
        float actual = bl.calculate("2*3/0*sin(45-6)");
        float expected = Float.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test22() {
        float actual = bl.calculate("2*3+5-7+8/2-tan(5*3*3)");
        float expected = (float) 7.0;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test23() {
        float actual = bl.calculate("sin(2*3+100-200+55-60/3+30/10)");
        float expected = (float) -0.82903757255;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test24() {
        float actual = bl.calculate("sin(((2*3+100-200+55-60)/(3+30))/10)");
        float expected = (float) -0.00523596383;

        assertEquals(expected, actual, delta);
    }

    @Test
    public void test25() {
        float actual = bl.calculate("tan(0)/0");
        float expected = Float.NaN;
        assertEquals(expected, actual, delta);
    }

}