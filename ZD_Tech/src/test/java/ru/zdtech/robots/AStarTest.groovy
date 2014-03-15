package ru.zdtech.robots

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
class AStarTest extends GroovyTestCase {
    def field5x5


    @Override
    void setUp() {
        super.setUp();
        field5x5 = new Field(5, 5, new Position(0, 0), new Position(4, 4))
    }

    void testAStar() {
        def aStar = new AStar(robot: RoboFactory.instance.createRobot(RobotType.DIAGONAL, field5x5))
        def solve = aStar.solve()

//        assertEquals([field5x5.getEnd(), field5x5.getStart()], [solve[0], solve[-1]])
        // потому что решение - путь от конца к началу
        // todo какая-то фигня с ==
        assertTrue(solve[0].equals(field5x5.getEnd()))
        assertTrue(solve[-1].equals(field5x5.getStart()))
        field5x5.print(solve)
    }

    void testName() {
        field5x5.print([])

    }
}
