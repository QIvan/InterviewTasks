package ru.zdtech.robots

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
class AStar {

    Robot robot
    final def COST = 10

    def solve() {
        def field = robot.getField()
        def closeList = []
        Queue<Position> openList = new PriorityQueue<Position>();
        openList.add(new Position(field.getStart(), 0, field.calcDistanceToEnd(field.getStart())))

        while (!openList.isEmpty()) {
            Position currPos = openList.poll()
            closeList << currPos

            if (currPos.equals(field.getEnd()))
                return getPath(currPos, field.getStart())

            def listNeighbors = field.deleteIllegalSteps(robot.getAllLegalSteps(currPos)).findAll {
                !closeList.contains(it)
            }

            listNeighbors.each {
                //todo это можно сделать короче?
                def inOpenList = false
                def pos = openList.find {elem -> if (it == elem) {inOpenList = true; return true}} ?: it
                def costFormStart = currPos.costFromStart + COST
                if (pos.costFromStart == -1 || pos.costFromStart > costFormStart)
                {
                    pos.costFromStart = costFormStart
                    pos.setPrevPos(currPos)
                }
                if (!inOpenList)
                {
                    pos.costHeuristic = field.calcDistanceToEnd(pos)
                    openList << pos
                }
            }
        }
        return []
    }

    List<Position> getPath(Position end, Position start)
    {
        def result = [end]
        def prevPos = end
        while (!prevPos.equals(start))
            result << (prevPos = prevPos.getPrevPos())
        return result
    }

}
