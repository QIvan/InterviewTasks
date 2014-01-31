package ru.zdtech.robots;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class Position
{
    private int x;
    private int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("x:%o y:%o", x, y);
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
                                 Math.pow(start.getX() - end.getY(), 2));
    }
}
