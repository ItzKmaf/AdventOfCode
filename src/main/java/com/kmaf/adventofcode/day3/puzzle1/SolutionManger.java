package com.kmaf.adventofcode.day3.puzzle1;

public class SolutionManger {
    private static SolutionManger instance;

    private int partNumber = 0;

    private SolutionManger() {

    }

    public static SolutionManger getInstance() {
        if (instance == null) {
            instance = new SolutionManger();
        }
        return instance;
    }

    /**
     * Increments the part number by a given value
     * @param partNumberPart the value we should increment the part number by
     * @throws IllegalArgumentException If the provided part number is below zero.
     */
    public void incrementPartNumber(int partNumberPart) {
        if (partNumberPart < 0) {
            throw new IllegalArgumentException("Part Numbers may not be negative");
        }
        partNumber += partNumberPart;
    }

    public void displayResult() {
        System.out.println("Found part-number: " + partNumber);
    }
}
