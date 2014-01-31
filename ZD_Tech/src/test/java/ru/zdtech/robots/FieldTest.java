package ru.zdtech.robots;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public class FieldTest {
    @Test
    public void testDeleteIllegalSteps() throws Exception
    {
        Field field = new Field(5, 5, new Position(0,0), new Position(0, 1));
        LinkedList<Position> positions = new LinkedList<Position>();
        positions.add(new Position(0,0));
        positions.add(new Position(-1,0));
        positions.add(new Position(0,-1));
        positions.add(new Position(-1,-1));
        positions.add(new Position(5,0));
        positions.add(new Position(0,5));
        positions.add(new Position(5,5));
        positions.add(new Position(4,4));
        Assert.assertArrayEquals(new Position[] { new Position(0,0), new Position(4,4) },
                                 field.deleteIllegalSteps(positions).toArray());
    }
}
