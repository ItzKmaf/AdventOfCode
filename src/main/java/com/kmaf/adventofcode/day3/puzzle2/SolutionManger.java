package com.kmaf.adventofcode.day3.puzzle2;

public class SolutionManger {
    private static SolutionManger instance;

    private int gearRatio = 0;

    private SolutionManger() {

    }

    public static SolutionManger getInstance() {
        if (instance == null) {
            instance = new SolutionManger();
        }
        return instance;
    }


    public void incrementGearRatio(int gearRatioComponent) {
        if (gearRatioComponent < 0) {
            throw new IllegalArgumentException("Part Numbers may not be negative");
        }
        gearRatio += gearRatioComponent;
    }

    public void displayResult() {
        System.out.println("Found gear-ratio: " + gearRatio);
    }
}
