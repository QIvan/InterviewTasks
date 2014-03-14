package ru.zdtech.robots

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
class AStarTest extends GroovyTestCase {

    void testAStar() {
        def field = new Field(5, 5, new Position(0, 0), new Position(4, 4))
//        field.addWall(new Position(2,1))
        field.addWall(new Position(2,2))
        (0..3).each { field.addWall(new Position(it, 2)) }
        def aStar = new AStar(robot: RoboFactory.instance.createRobot(RobotType.DIAGONAL, field))

        def solve = aStar.solve()
        println "solve " + solve

        field.print(solve)
//        assertEquals([new Position(1,0), new Position(0,1)], solve)

    }
}
