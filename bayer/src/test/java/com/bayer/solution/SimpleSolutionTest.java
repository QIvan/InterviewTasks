package com.bayer.solution;

import com.bayer.figure.Circle;
import com.bayer.figure.Figure;
import com.bayer.figure.Square;
import com.bayer.result.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Zemlyanskiy
 */
@RunWith(Parameterized.class)
public class SimpleSolutionTest {

    private List<Figure> figures;
    int count;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10},
                {100000},
        });
    }

    public SimpleSolutionTest(int count) {
        this.count = count;
        figures = new ArrayList<>();
    }

    @Before
    public void setup() throws Exception {
        for (int i = 0; i < count / 2; i++) {
            figures.add(new Square(1));
        }
        for (int i = count / 2; i < count; i++) {
            figures.add(new Circle(1));
        }
    }

    @Test
    public void testSolve() throws Exception {
        List<Result> results = new SimpleSolution(Executors.newWorkStealingPool()).solve(figures);

        double squarePerimeter = 4;
        double squareArea = 1;
        for (int i = 0; i < count / 2; i++) {
            assertEquals(squarePerimeter, results.get(i).getPerimeter(), 0.00001);
            assertEquals(squareArea, results.get(i).getArea(), 0.00001);
        }

        double circlePerimeter = Math.PI * 2;
        double circleArea = Math.PI;
        for (int i = count / 2; i < count; i++) {
            assertEquals(circlePerimeter, results.get(i).getPerimeter(), 0.00001);
            assertEquals(circleArea, results.get(i).getArea(), 0.00001);
        }
    }
}