package com.kmaf.adventofcode.day1.puzzle1;

import lombok.Getter;

@Getter
public class PuzzleLine {

    private final int firstNum;
    private final int lastNum;
    public PuzzleLine(String line) {
        // Replace all non strings with spaces
        String numberList = line.replaceAll("[^0-9]", " ");
        // Reduce all spaces (consecutive or single) to a comma.
        numberList = numberList.trim().replaceAll(" +", ",");
        // Collect the numbers into a String Array
        String[] validNumbers = numberList.split(",");
        // If the line contained zero numbers, set the values to 0 and return
        if (validNumbers.length == 0) {
            firstNum = 0;
            lastNum = 0;
            return;
        }
        // Otherwise, Grab the values
        firstNum = Integer.parseInt(String.valueOf(validNumbers[0].charAt(0)));
        lastNum = Integer.parseInt(String.valueOf(validNumbers[validNumbers.length-1].charAt((validNumbers[validNumbers.length-1]).length() -1)));
    }
}
