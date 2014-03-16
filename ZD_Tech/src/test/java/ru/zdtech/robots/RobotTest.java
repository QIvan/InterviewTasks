package ru.zdtech.robots;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class RobotTest {


    private Field simpleField5x5 = new Field(5, 5, new Position(0,0), new Position(0, 1));

    @Test
    public void testStep() throws Exception
    {
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, simpleField5x5);
        Assert.assertEquals(robot.getCurrentPos(), simpleField5x5.getStart());
        robot.step(new Position(0,1));
        Assert.assertEquals(robot.getCurrentPos(), new Position(0,1));
    }

    @Test
    public void testAllSteps() throws Exception
    {
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, simpleField5x5);
        Assert.assertArrayEquals(robot.getAllLegalSteps().toArray(),
                                 new Position[] { new Position(1, 0), new Position(0, 1)});

        robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE,
                                                       new Field(10, 10, new Position(3,3), new Position(5,5)));
        Assert.assertArrayEquals(new Position[] { new Position(3, 2), new Position(4, 3),
                new Position(3, 4), new Position(2, 3)},
                                 robot.getAllLegalSteps().toArray());

        Field field10x10 = new Field(10, 10, new Position(3, 3), new Position(5, 5));
        robot = RoboFactory.getInstance().createRobot(RobotType.DIAGONAL, field10x10);
        robot.step(new Position(1,1));
        field10x10.addWall(new Position(2,2));
        Assert.assertArrayEquals(new Position[] { new Position(0, 0), new Position(2, 0), new Position(0, 2)},
                                 robot.getAllLegalSteps().toArray());


    }


    @Test
    public void testSimpleSolution() throws Exception
    {
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, simpleField5x5);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(),
                                 new Position[]{simpleField5x5.getStart(), simpleField5x5.getEnd()},
                                 solution.toArray());
    }

    @Test
    public void testLineSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(0, 2));
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(),
                                 new Position[]{field.getStart(), new Position(0, 1), field.getEnd()},
                                 solution.toArray());

    }

    @Test
    public void testDiagonalSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(1, 1));
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(),
                                 new Position[]{field.getStart(), new Position(1, 0), field.getEnd()},
                                 solution.toArray());

        robot = RoboFactory.getInstance().createRobot(RobotType.DIAGONAL, field);
        solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(),
                                 new Position[]{field.getStart(), field.getEnd()},
                                 solution.toArray());

    }

    @Test
    public void testLongDiagonalSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(4, 2));
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(),
                                 new Position[]{field.getStart(), new Position(1, 0), new Position(2, 0),
                                                 new Position(3, 0), new Position(3, 1), new Position(4,1),
                                                 field.getEnd()},
                                 solution.toArray());

    }

    @Test
    public void testWalls() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(1, 1));
        field.addWall(new Position(0, 1));
        Robot robot = RoboFactory.getInstance().createRobot(RobotType.SIMPLE, field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(),
                                 new Position[]{field.getStart(), new Position(1, 0), field.getEnd()},
                                 solution.toArray());

    }
}
