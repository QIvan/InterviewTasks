package ru.zdtech.robots;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class Position  implements Comparable<Position>
{
    final private int x;
    final private int y;
    private Position prevPos = null;
    //TODO вообще говоря эти значения имеют смысл
    //только для конкретного поля,а не для координаты.
    private double costFromStart = -1;
    private double costHeuristic = -1;

    public double cost() { return costFromStart + costHeuristic;}

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos, double costHeuristic, double costFromStart)
    {
        this.x = pos.getX();
        this.y = pos.getY();
        this.costHeuristic = costHeuristic;
        this.costFromStart = costFromStart;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public double getCostFromStart()
    {
        return costFromStart;
    }

    public void setCostFromStart(double costFromStart)
    {
        this.costFromStart = costFromStart;
    }

    public double getCostHeuristic()
    {
        return costHeuristic;
    }

    public void setCostHeuristic(double costHeuristic)
    {
        this.costHeuristic = costHeuristic;
    }

    public Position getPrevPos()
    {
        return prevPos;
    }

    public void setPrevPos(Position prevPos)
    {
        this.prevPos = prevPos;
    }

    @Override
    public String toString()
    {
        String result =  String.format("{x:%d y:%d", x, y);
//        result += String.format(", [costFromStart=%.1f costHeuristic=%.1f cost=%.1f]" , costFromStart, costHeuristic, cost());
        result += "}";
        return result;
    }

    public static double calcDistance(Position start, Position end)
    {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2)
                                 +
                                 Math.pow(start.getY() - end.getY(), 2));
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
        return Double.compare(cost(), position.cost());
    }


}
