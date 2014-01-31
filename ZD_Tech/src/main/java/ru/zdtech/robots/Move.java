package ru.zdtech.robots;

import java.util.List;

/**
 * Class of the project ZD_Tech
 * Developer: ivan
 */
public interface Move {

    public List<Position> getNextPositions(Position currentPos);

}
