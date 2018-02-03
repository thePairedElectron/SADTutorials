package tests;

import businesslogic.SimpleCalc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalcTest {
    
    private SimpleCalc bl;
    private float delta = (float)0.000000002;
    @Before
    public void setUp() {
        bl = new SimpleCalc();
    }

    @Test
    public void test1() {
        float actual = bl.calculate("1 + 2");
        float expected = (float)3;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test2() {
        float actual = bl.calculate("1 - 2");
        float expected = (float)-1;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test3() {
        float actual = bl.calculate("1 * 2");
        float expected = (float)2;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test4() {
        float actual = bl.calculate("1 / 2");
        float expected = (float)0.5;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test5() {
        
        float actual = bl.calculate("2 + 3 * 4");
        float expected = (float)14;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test6() {
        float actual = bl.calculate("2 + 3 - 4");
        float expected = 1;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test7() {
        float actual = bl.calculate("2 + 3 / 4");
        float expected = (float)2.75;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test8() {
        float actual = bl.calculate("2 + 3 * 4 / 5");
        float expected = (float)4.4;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test9() {
        float actual = bl.calculate("2 + 3 * 4 - 5");
        float expected = (float)9;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test10() {
        float actual = bl.calculate("( 2 + 3 ) * 5");
        float expected = (float)25;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test11() {
        float actual = bl.calculate("( 2 - 3 ) * 5");
        float expected = (float)-5;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test12() {
        float actual = bl.calculate("( 2 * 3 ) / 5");
        float expected = (float)1.2;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test13() {
        float actual = bl.calculate("( 2 + 3 ) / ( 2 - 3 )");
        float expected = (float)-5;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test14() {
        float actual = bl.calculate("( 2 * 3 ) + ( 2 / 5 )");
        float expected = (float)6.4;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test15() {
        float actual = bl.calculate("( 2 * 6 ) + ( 2 / 5 )");
        float expected = (float)12.4;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test16() {
        float actual = bl.calculate("( 2 * 6 ) + ( 2 / 5 )-(2/4)");
        float expected = (float)11.9;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test17() {
        float actual = bl.calculate("( 2 * 6 ) + ( 2 / 5 )-(40)");
        float expected = (float)-27.6;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test18() {
        float actual = bl.calculate("4 / 0 * 5");
        float expected = Float.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test19() {
        float actual = bl.calculate("2+3*5");
        float expected = (float)17;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test20() {
        float actual = bl.calculate("2*3/5");
        float expected = (float)1.2;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void test21() {
        float actual = bl.calculate("2*3/0");
        float expected =Float.POSITIVE_INFINITY;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test22() {
        float actual = bl.calculate("2*3+5-7+8/2");
        float expected = (float)8.0;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test23() {
        float actual = bl.calculate("2*3+100-200+55-60/3+30/10");
        float expected = (float)-56.0;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test24() {
        float actual = bl.calculate("((2*3+100-200+55-60)/(3+30))/10");
        float expected = (float)-0.3;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void test25() {
        float actual = bl.calculate("0/0");
        float expected = Float.NaN;
        assertEquals(expected, actual, delta);
    }
}