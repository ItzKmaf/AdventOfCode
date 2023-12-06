package com.kmaf.adventofcode.day3.puzzle2;

import java.util.ArrayList;

public class CoordManager {
    private final ArrayList<Integer>[] possiblePartChords = (ArrayList<Integer>[]) new ArrayList[500];

    private static CoordManager instance;

    private CoordManager() {

    }

    public static CoordManager getInstance() {
        if (instance == null) {
            instance = new CoordManager();
        }
        return instance;
    }

    /**
     * Adds a given coordinate after checking it doesn't already exist within the coord storage.
     * @param row the row that we need to insert.
     * @param column the column that we need to insert.
     * @throws IllegalArgumentException when the provided row is less than zero or greater than 500 or when the provided
     * column is less than zero or greater than 300
     */
    public void addCoord(int row, int column) {
        if (row < 0 || row > 500) {
            throw new IllegalArgumentException("The Coordinate row must be between 0 and 500, You provided " + row);
        }
        if (column < 0 || column> 300) {
            throw new IllegalArgumentException("The Coordinate column must be between 0 and 300, You provided " + row);
        }
        // If this row hasn't been initialised yet
        if (possiblePartChords[row] == null) {
            possiblePartChords[row] = new ArrayList<>();
        }
        // If we already have this coord in our list, don't bother adding it again
        if (possiblePartChords[row].contains(column)) {
            return;
        }
        // Add the coord
        possiblePartChords[row].add(column);
    }

    public boolean hasCoord(int row) {
        if (possiblePartChords[row] == null) {
            return false;
        }
        return !possiblePartChords[row].isEmpty();
    }

    public ArrayList<Integer> getCoords(int row) {
        if (possiblePartChords[row] == null) {
            return new ArrayList<>();
        }
        return possiblePartChords[row];
    }
}
