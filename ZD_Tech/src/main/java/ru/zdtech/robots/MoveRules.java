package ru.zdtech.robots;

import java.util.LinkedList;
import java.util.List;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class MoveRules implements Move
{
    private Step[] stepList;

    public MoveRules(Step ... stepList)
    {
        this.stepList = stepList;
    }

    @Override
    public List<Position> getNextPositions(Position currentPos)
    {
        List<Position> result = new LinkedList<Position>();
        for (Step step : stepList)
        {
            result.add(step.getStep(currentPos));
        }
        return result;
    }

}
