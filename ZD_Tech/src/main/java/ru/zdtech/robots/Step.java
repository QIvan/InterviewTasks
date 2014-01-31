package ru.zdtech.robots;

/**
* Class of the project ZD_Tech
* Developer: ivan
*/ //TODO может не очень хорошее название для класса
public class Step
{
    private final int deltax;
    private final int deltay;

    public Step(int deltax, int deltay)
    {
        this.deltax = deltax;
        this.deltay = deltay;

    }
    public Position getStep(Position pos)
    {
        return new Position(pos.getX() + deltax, pos.getY() + deltay);
    }
}
