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


    public Field(int n, int m, Position start, Position end)
    {
        X_SIZE = n;
        Y_SIZE = m;
        START = start;
        END = end;
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
                result.add(pos);
            }
        }
        return result;
    }
}
