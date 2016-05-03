package com.bayer.result;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Ivan Zemlyanskiy
 */
@Slf4j
public class Result {

    private double perimeter;
    private double area;

    public Result() {
    }

    public Result(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
