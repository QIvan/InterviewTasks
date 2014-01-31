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
        Robot robot = new Robot(simpleField5x5);
        Assert.assertEquals(robot.getCurrentPos(), simpleField5x5.getStart());
        robot.step(new Position(0,1));
        Assert.assertEquals(robot.getCurrentPos(), new Position(0,1));
    }

    @Test
    public void testAllSteps() throws Exception
    {
        Robot robot = new Robot(simpleField5x5);
        Assert.assertArrayEquals(robot.getAllSteps().toArray(),
                                 new Position[] { new Position(1, 0), new Position(0, 1)});

        robot = new Robot(new Field(10, 10, new Position(3,3), new Position(5,5)));
        Assert.assertArrayEquals(new Position[] { new Position(3, 2), new Position(4, 3),
                new Position(3, 4), new Position(2, 3)},
                                 robot.getAllSteps().toArray());

    }


    @Test
    public void testSimpleSolution() throws Exception
    {
        Robot robot = new Robot(simpleField5x5);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(), solution.toArray(),
                                 new Position[]{simpleField5x5.getStart(), simpleField5x5.getEnd()});
    }

    @Test
    public void testLineSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(0, 2));
        Robot robot = new Robot(field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(), solution.toArray(),
                                 new Position[]{field.getStart(), new Position(0, 1), field.getEnd()});

    }

    @Test
    public void testDioganalSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(1, 1));
        Robot robot = new Robot(field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(), solution.toArray(),
                                 new Position[]{field.getStart(), new Position(1, 0), field.getEnd()});

    }

    @Test
    public void testLongDioganalSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0, 0), new Position(4, 2));
        Robot robot = new Robot(field);
        List<Position> solution = robot.findSolution();
        Assert.assertArrayEquals(solution.toString(), solution.toArray(),
                                 new Position[]{field.getStart(), new Position(1, 0), new Position(2, 0),
                                                 new Position(3, 0), new Position(3, 1), new Position(4,1),
                                                 field.getEnd()});

    }
}
