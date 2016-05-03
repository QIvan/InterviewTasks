/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.bayer;

import com.bayer.figure.Circle;
import com.bayer.figure.Figure;
import com.bayer.figure.Square;
import com.bayer.result.FutureResult;
import com.bayer.result.Result;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class SolveBenchmark {

    @Param({"10", "1000000"})
    private int count;
    private List<Result> results = new ArrayList<>();

    List<Figure> figures = new ArrayList<>();

    @Setup
    public void setup() {
        for (int i = 0; i < count / 2; i++) {
            figures.add(new Square(10));
        }
        for (int i = count / 2; i < count; i++) {
            figures.add(new Circle(5));
        }
    }

    @TearDown
    public void verify() {
        double squareArea = new Square(10).calcArea();
        double squarePerimeter = new Square(10).calcPerimeter();
        for (int i = 0; i < count / 2; i++) {
            assert results.get(i).getArea() == squareArea : "Wrong! ";
            assert results.get(i).getPerimeter() == squarePerimeter : "Wrong! ";
        }

        double circleArea = new Circle(5).calcArea();
        double circlePerimeter = new Circle(5).calcPerimeter();
        for (int i = count / 2; i < count; i++) {
            assert results.get(i).getArea() == circleArea : "Wrong! ";
            assert results.get(i).getPerimeter() == circlePerimeter : "Wrong! ";
        }
    }

    @Benchmark
    public void parallelStream() {
        ExecutorService executor = Executors.newWorkStealingPool();
        results = figures.parallelStream()
                .map(figure ->
                        new FutureResult(
                                executor.submit(figure::calcPerimeter),
                                executor.submit(figure::calcArea)))
                .map(future -> new Result(future.getPerimeter(), future.getArea()))
                .collect(Collectors.toList());

    }


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(SolveBenchmark.class.getSimpleName())
                .measurementIterations(1)
                .threads(1)
                .forks(1)
                .warmupIterations(6)
                .measurementIterations(10)
                .build();

        new Runner(opt).run();
    }


}
