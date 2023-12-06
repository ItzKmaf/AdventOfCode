package com.kmaf.adventofcode.day3.puzzle2;

import java.util.ArrayList;

public class NumberScanner {

    public NumberScanner(FileLine line1, FileLine line2, FileLine line3) {
        if ((line1 == null && line3 == null) || line2 == null) {
            return;
        }
        checkLines(line1, line2, line3);
    }

    private void checkLines(FileLine line1, FileLine line2, FileLine line3) {
        if (line3 == null) {
            checkGear(line1, line2, new FileLine(new String(new char[line2.getLine().length()]).replace('\0', ' '), line2.getLineNumber() + 1));
            return;
        }
        if (line1 == null) {
            checkGear(new FileLine(new String(new char[line2.getLine().length()]).replace('\0', ' '), line2.getLineNumber() - 1), line2, line3);
            return;
        }
        checkGear(line1, line2, line3);
    }

    private void checkGear(FileLine line1, FileLine line2, FileLine line3) {
        SolutionManger solutionManger = SolutionManger.getInstance();
        CoordManager coordManager = CoordManager.getInstance();
        if (!coordManager.hasCoord(line2.getLineNumber())) {
            return;
        }
        ArrayList<Integer> coords = coordManager.getCoords(line2.getLineNumber());
        System.out.println("\n\n\n");
        System.out.println(line1.getLine());
        System.out.println(line2.getLine());
        System.out.println(line3.getLine());
        for (Integer coord: coords) {
            int foundNumber = 0;
            foundNumber += getAdjacentNumbers(line1, coord);
            foundNumber += getAdjacentNumbers(line2, coord);
            foundNumber += getAdjacentNumbers(line3, coord);
            if (foundNumber == 2) {
                ArrayList<Integer> numbers = new ArrayList<>();
                numbers.addAll(getCompleteNumbers(line1.getLine(), coord));
                numbers.addAll(getCompleteNumbers(line2.getLine(), coord));
                numbers.addAll(getCompleteNumbers(line3.getLine(), coord));
                if (numbers.size() != 2) {
                    throw new IllegalArgumentException("Expected two numbers but got: " + numbers.size());
                } else {
                    System.out.println(numbers);
                    solutionManger.incrementGearRatio(numbers.get(0) * numbers.get(1));
                }
            }
        }
    }

    private int getAdjacentNumbers(FileLine line, Integer coord) {
        if (coord > 0) {
            if (isNumber(line.getLine(), coord - 1)) {
                if (isNumber(line.getLine(), coord + 1) && !isNumber(line.getLine(), coord)) {
                    return 2;
                }
                return 1;
            }
        }
        if (isNumber(line.getLine(), coord)) {
            return 1;
        } else {
            if (isNumber(line.getLine(), coord + 1)) {
                return 1;
            }
        }
        return 0;
    }

    private boolean isNumber(String line, int column) {
        if (column < 0) {
            return false;
        }
        String character = Character.toString(line.charAt(column));
        return character.matches("^[0-9]*$");
    }

    private ArrayList<Integer> getCompleteNumbers(String line, int column) {
        ArrayList<Integer> numbers = new ArrayList<>();
        if (isNumber(line, column -1)) {
            numbers.add(getNumberLeft(line, column -1));
            if (!isNumber(line, column) && isNumber(line, column + 1)) {
                numbers.add(getNumber(line, column + 1));
            }
        } else if (isNumber(line, column)) {
            numbers.add(getNumber(line, column));
        } else if (isNumber(line, column + 1)) {
            numbers.add(getNumber(line, column +1));
        }
        return numbers;
    }

    private int getNumberLeft(String line, int column) {
        while (isNumber(line, column)) {
            column --;
        }
        return getNumber(line, column + 1);
    }

    private int getNumber(String line, int numberStart) {
        StringBuilder number = new StringBuilder();
        while (isNumber(line, numberStart)) {
            number.append(line.charAt(numberStart));
            numberStart ++;
        }
        return Integer.parseInt(number.toString());
    }

}
