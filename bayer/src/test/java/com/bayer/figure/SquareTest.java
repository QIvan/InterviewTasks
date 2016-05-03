package com.bayer.figure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ivan Zemlyanskiy
 */
public class SquareTest {

    @Test
    public void testCalcArea() throws Exception {
        assertEquals(1, new Square(1).calcArea(), 0.001);
        assertEquals(4, new Square(2).calcArea(), 0.001);
        assertEquals(0.25, new Square(0.5).calcArea(), 0.001);
    }

    @Test
    public void testCalcPerimeter() throws Exception {
        assertEquals(4, new Square(1).calcPerimeter(), 0.001);
        assertEquals(8, new Square(2).calcPerimeter(), 0.001);
        assertEquals(2, new Square(0.5).calcPerimeter(), 0.001);
    }
}