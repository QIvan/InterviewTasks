package com.bayer.figure;

/**
 * @author Ivan Zemlyanskiy
 */
public class Square implements Figure {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calcArea() {
        return Math.pow(side, 2);
    }

    public double calcPerimeter() {
        return 4 * side;
    }
}
