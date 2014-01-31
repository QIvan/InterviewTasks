package ru.zdtech.robots;

import java.util.LinkedList;
import java.util.List;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
class Robot
{
    private Field field;
    private Position currentPos;

    private List<Position> solution = new LinkedList<Position>();

    public Robot(Field field)
    {
        this.field = field;
        currentPos = field.getStart();
        solution.add(field.getStart());
    }

    public void step(Position position)
    {
        currentPos = position;
        solution.add(position);
    }

    private enum Step
    {
        UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0);
        private int deltax;
        private int deltay;

        Step(int deltax, int deltay)
        {
            this.deltax = deltax;
            this.deltay = deltay;
        }
        public Position getStep(Position pos)
        {
            return new Position(pos.getX() + deltax, pos.getY() + deltay);
        }
    }

    public List<Position> getAllSteps()
    {
        List<Position> steps = new LinkedList<Position>();
        for (Step step : Step.values())
        {
            steps.add(step.getStep(currentPos));
        }
        return field.deleteIllegalSteps(steps);
    }

    public List<Position> findSolution()
    {
        System.out.println("End : " + field.getEnd());
        System.out.println();
        while (!currentPos.equals(field.getEnd()))
        {
            // I wanna lambda-functions!!!
            List<Position> allSteps = getAllSteps();
            Position next = allSteps.get(0);
            Double min = Position.calcDistance(next, field.getEnd());
            for (Position pos : allSteps)
                if (min > Position.calcDistance(pos, field.getEnd()))
                {
                    next = pos;
                    min = Position.calcDistance(pos, field.getEnd());
                }
            System.out.println("Next: " + next);
            step(next);
        }

        return solution;
    }

    Position getCurrentPos()
    {
        return currentPos;
    }
}
