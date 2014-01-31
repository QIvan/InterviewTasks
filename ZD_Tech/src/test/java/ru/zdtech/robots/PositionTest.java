package ru.zdtech.robots;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class PositionTest {
    @Test
    public void testEquals() throws Exception
    {
        Assert.assertEquals(new Position(0,0), new Position(0,0));
        Assert.assertFalse(new Position(1,0).equals(new Position(0,0)));
        Assert.assertFalse(new Position(0,1).equals(new Position(0,0)));
        Assert.assertFalse(new Position(0,0).equals(new Position(1,1)));
    }

    @Test
    public void testCalcDistance() throws Exception
    {
        Assert.assertEquals(Position.calcDistance(new Position(0,0), new Position(0,0)), 0.0);
    }
}
