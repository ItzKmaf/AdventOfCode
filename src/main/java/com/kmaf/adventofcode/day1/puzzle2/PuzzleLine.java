package com.kmaf.adventofcode.day1.puzzle2;

import lombok.Getter;

@Getter
public class PuzzleLine {

    private final int firstNum;
    private final int lastNum;
    public PuzzleLine(String line) {
        // Replace any spelt numbers with numerical characters - This is ugly but, It works
        line = line.replace("zero", "zero0zero");
        line = line.replace("one", "one1one");
        line = line.replace("two", "two2two");
        line = line.replace("three", "three3three");
        line = line.replace("four", "four4four");
        line = line.replace("five", "five5five");
        line = line.replace("six", "six6six");
        line = line.replace("seven", "seven7seven");
        line = line.replace("eight", "eight8eight");
        line = line.replace("nine", "nine9nine");
        // Remove all non strings
        String numberList = line.replaceAll("[^0-9]", "");
        // Split the String of numbers into characters
        char[] validNumbers = numberList.toCharArray();
        // If the line contained zero numbers, set the values to 0 and return
        if (validNumbers.length == 0) {
            firstNum = 0;
            lastNum = 0;
            return;
        }
        System.out.println(numberList);
        // Otherwise, Grab the values
        firstNum = Integer.parseInt(String.valueOf(validNumbers[0]));
        lastNum = Integer.parseInt(String.valueOf(validNumbers[validNumbers.length-1]));
        System.out.println("First Num: " + firstNum + ", Last Num: " + lastNum);
    }
}
