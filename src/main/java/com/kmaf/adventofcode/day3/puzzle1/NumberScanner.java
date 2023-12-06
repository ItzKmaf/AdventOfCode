package com.kmaf.adventofcode.day3.puzzle1;

public class NumberScanner {

    public NumberScanner(String lineToScan, int lineIndex) {
        int column = 1;
        StringBuilder currentNumber = new StringBuilder();
        boolean recordNumber = false;
        SolutionManger solutionManger = SolutionManger.getInstance();
        CoordManager coordManager = CoordManager.getInstance();
        for (char lineChar: lineToScan.toCharArray()) {
            String character = Character.toString(lineChar);

            // If the current character is not a number.
            if (!character.matches("^[0-9]*$")) {
                if (recordNumber && (currentNumber.length() > 0)) {
                    solutionManger.incrementPartNumber(Integer.parseInt(currentNumber.toString()));
                }
                // Then clear the current number and continue the loop.
                currentNumber = new StringBuilder();
                recordNumber = false;
                column ++;
                continue;
            }
            // Check if we should be recording the number
            recordNumber = (recordNumber && currentNumber.length() > 0) || coordManager.isRegisteredCoord(lineIndex, column);
            currentNumber.append(character);
            column ++;
        }
        if (recordNumber && (currentNumber.length() > 0)) {
            solutionManger.incrementPartNumber(Integer.parseInt(currentNumber.toString()));
        }
    }
}
