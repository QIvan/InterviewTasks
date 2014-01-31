package ru.zdtech.robots;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class Field
{
    private final int N;
    private final int M;

    private final Position START;
    private final Position END;


    public Field(int n, int m, Position start, Position end)
    {
        N = n;
        M = m;
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
}
