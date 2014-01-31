package ru.zdtech.robots;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class RobotTest {


    @Test
    public void testFindSolution() throws Exception
    {
        Field field = new Field(5, 5, new Position(0,0), new Position(0, 1));
        Robot robot = new Robot(field);
        Assert.assertArrayEquals(robot.findSolution().toArray(),
                                 new Position[]{ field.getStart(), field.getEnd() });

    }
}
