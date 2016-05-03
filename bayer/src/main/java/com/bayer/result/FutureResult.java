package com.bayer.result;

import java.util.concurrent.Future;


/**
 * @author Ivan Zemlyanskiy
 */
public class FutureResult extends Result {
    public Future<Double> perimeter;
    public Future<Double> area;

    public FutureResult(Future<Double> perimeter, Future<Double> area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    @Override
    public double getPerimeter() {
        try {
            return perimeter.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getArea() {
        try {
            return area.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
