package com.bayer.solution;

import com.bayer.figure.Figure;
import com.bayer.result.Result;

import java.util.List;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Solution {

    List<Result> solve(List<Figure> figures);
}
