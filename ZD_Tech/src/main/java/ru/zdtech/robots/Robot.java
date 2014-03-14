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
    private MoveRules moveRules;
    private Position currentPos;

    private List<Position> solution = new LinkedList<>();

    public Robot(Field field, MoveRules moveRules)
    {
        this.field = field;
        this.moveRules = moveRules;
        currentPos = field.getStart();
//        solution.add(field.getStart());
    }

    public void step(Position position)
    {
        currentPos = position;
        solution.add(position);
    }

    public List<Position> getAllLegalSteps()
    {
        return getAllLegalSteps(currentPos);
    }

    public List<Position> getAllLegalSteps(Position currentPos)
    {
        List<Position> steps = moveRules.getNextPositions(currentPos);
        return field.deleteIllegalSteps(steps);
    }

    public List<Position> findSolution()
    {
        return findSolution(currentPos);
    }

    //да-да, я последнее время немного увлёксся функциональными языками
    public List<Position> findSolution(Position currentPos)
    {
        LinkedList<Position> solution = new LinkedList<Position>();
        solution.add(currentPos);
        if (currentPos.equals(field.getEnd()))
            return solution;

        System.out.println("End : " + field.getEnd());
        System.out.println();
//        while (!getCurrentPos().equals(field.getEnd()))
//        {
            // I wanna lambda-functions!!!
            List<Position> allSteps = getAllLegalSteps(currentPos);
            Position next = allSteps.get(0);
            Double min = Position.calcDistance(next, field.getEnd());
            for (Position pos : allSteps)
                if (min > Position.calcDistance(pos, field.getEnd()))
                {
                    next = pos;
                    min = Position.calcDistance(pos, field.getEnd());
                }
            System.out.println("Curr: " + currentPos);
            System.out.println("Next: " + next);
            solution.addAll(findSolution(next));

//          }

        return solution;
    }

    Position getCurrentPos()
    {
        return currentPos;
    }

    public Field getField()
    {
        return field;
    }
}
