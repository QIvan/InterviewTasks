package ru.zdtech.robots;

import java.util.LinkedList;
import java.util.List;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class Field
{
    private final int X_SIZE;
    private final int Y_SIZE;

    private final Position START;
    private final Position END;

    private LinkedList<Position> walls = new LinkedList<Position>();

    public Field(int n, int m, Position start, Position end)
    {
        X_SIZE = n;
        Y_SIZE = m;
        START = start;
        END = end;
    }

    public void addWall(Position wall)
    {
        walls.add(wall);
    }

    public Position getStart()
    {
        return START;
    }

    public Position getEnd()
    {
        return END;
    }

    public List<Position> deleteIllegalSteps(List<Position> steps)
    {
        List<Position> result = new LinkedList<Position>();
        for (Position pos : steps)
        {
            if ((pos.getX() >= 0) && (pos.getX() < X_SIZE)
                    &&
                (pos.getY() >= 0) && (pos.getY() < Y_SIZE))
            {
                if (!walls.contains(pos))
                    result.add(pos);
            }
        }
        return result;
    }

    public double calcDistanceToEnd(Position pos)
    {
        return Position.calcDistance(getStart(), getEnd());
    }

    public void print (List<Position> path)
    {
        for (int y=0; y<Y_SIZE; ++y)
        {
            for (int x=0; x<X_SIZE; ++x)
            {
                Position currPos = new Position(x, y);
                if (currPos.equals(getStart()))
                    System.out.print("S");
                else if (currPos.equals(getEnd()))
                    System.out.print("E");
                else if (walls.contains(currPos))
                    System.out.print("w");
                else if (path.contains(currPos))
                    System.out.print("x");
                else
                    System.out.print("-");

            }
            System.out.println();
        }
    }
}
