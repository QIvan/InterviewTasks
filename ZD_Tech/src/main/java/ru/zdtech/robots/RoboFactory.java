package ru.zdtech.robots;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class RoboFactory
{
    private static RoboFactory factory = new RoboFactory();

    private RoboFactory() {}

    static public RoboFactory getInstance()
    {
        return factory;
    }

    Robot createRobot(RobotType type, Field field)
    {
        switch (type)
        {
            case SIMPLE:
                return new Robot(field, new MoveRules(new Step(0, -1), new Step(1, 0),
                                                       new Step(0, 1), new Step(-1, 0)));
            case DIAGONAL:
                return new Robot(field, new MoveRules(new Step(-1, -1), new Step(1, -1),
                                                       new Step(1, 1), new Step(-1, 1)));
            default:
                throw new IllegalArgumentException();
        }
    }
}
