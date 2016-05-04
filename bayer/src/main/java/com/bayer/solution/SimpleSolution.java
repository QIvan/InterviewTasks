package com.bayer.solution;

import com.bayer.figure.Figure;
import com.bayer.result.FutureResult;
import com.bayer.result.Result;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;


/**
 * @author Ivan Zemlyanskiy
 */
public class SimpleSolution implements Solution{
    private ExecutorService executor;

    public SimpleSolution(ExecutorService executor) {
        this.executor = executor;
    }

    public List<Result> solve(List<Figure> figures) {
        return figures.parallelStream()
                .map(figure ->
                        new FutureResult(
                                executor.submit(figure::calcPerimeter),
                                executor.submit(figure::calcArea)))
                .map(future -> new Result(future.getPerimeter(), future.getArea()))
                .collect(Collectors.toList());
    }
}
