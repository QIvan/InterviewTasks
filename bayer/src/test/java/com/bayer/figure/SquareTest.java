package com.bayer.figure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Zemlyanskiy
 */
@RunWith(Parameterized.class)
public class SquareTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 4, 1},
                {2, 8, 4},
                {0.5, 2, 0.25},
        });
    }

    private double input;
    private double perimeter;
    private double area;

    public SquareTest(double input, double perimeter, double area) {
        this.input = input;
        this.perimeter = perimeter;
        this.area = area;
    }

    @Test
    public void testCalc() throws Exception {
        assertEquals(perimeter, new Square(input).calcPerimeter(), 0.001);
        assertEquals(area, new Square(input).calcArea(), 0.001);
    }

}