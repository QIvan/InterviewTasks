package ru.zdtech.robots;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
class Robot
{
    private Field field;

    public Robot(Field field)
    {
        this.field = field;
    }


    public List<Position> findSolution()
    {
        ArrayList<Position> solution = new ArrayList<Position>(2);
        solution.add(field.getStart());
        solution.add(field.getEnd());
        return solution;
    }
}
