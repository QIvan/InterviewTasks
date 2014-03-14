package ru.zdtech.robots;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class Position  implements Comparable<Position>
{
    final private int x;
    final private int y;
    private Position posFrom = null;
    public double g = -1;
    public double h = -1;
    public double f() { return g + h;}

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos, double h, double g)
    {
        this.x = pos.getX();
        this.y = pos.getY();
        this.h = h;
        this.g = g;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Position getPosFrom()
    {
        return posFrom;
    }

    public void setPosFrom(Position posFrom)
    {
        this.posFrom = posFrom;
    }

    @Override
    public String toString()
    {
        String result =  String.format("{x:%d y:%d", x, y);
//        result += String.format(", [g=%.1f h=%.1f f=%.1f]" , g, h, f());
        result += "}";
        return result;
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

    @Override
    public int compareTo(Position position)
    {
        return Double.compare(f(), position.f());
    }

    public static double calcDistance(Position start, Position end)
    {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2)
                                 +
                                 Math.pow(start.getY() - end.getY(), 2));
    }
}
