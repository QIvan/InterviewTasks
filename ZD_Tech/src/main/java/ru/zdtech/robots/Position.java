package ru.zdtech.robots;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class Position
{
    final private int x;
    final private int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return String.format("x:%d y:%d", x, y);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Position)
        {
            Position pos = (Position) obj;
            return (pos.getX() == x) && (pos.getY() == y);
        }
        return false;
    }

    public static double calcDistance(Position start, Position end)
    {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2)
                                 +
                                 Math.pow(start.getY() - end.getY(), 2));
    }
}
