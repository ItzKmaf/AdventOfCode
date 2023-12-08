package com.kmaf.adventofcode.day4.puzzle1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class PuzzleLine {

    ArrayList<String> winningNumbers;
    ArrayList<String> selectedNumbers;

    public PuzzleLine(String line) {
        String[] splitLine = line.split("\\|");
        selectedNumbers = new ArrayList<>(Arrays.asList(splitLine[1].trim().replaceAll("\\s{2,}", " ").replace(" ", ",").split(",")));
        winningNumbers = new ArrayList<>(Arrays.asList(splitLine[0].split(":")[1].trim().replaceAll("\\s{2,}", " ").replace(" ", ",").split(",")));
    }
}
