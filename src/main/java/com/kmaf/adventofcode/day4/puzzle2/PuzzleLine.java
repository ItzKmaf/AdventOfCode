package com.kmaf.adventofcode.day4.puzzle2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class PuzzleLine {

    private final int cardNumber;
    private final int score;

    public PuzzleLine(String line) {
        //Card 999: 99 9 999 99 99 999  999 999   999 | 9 9 9 9 999 9999 9999 99 9
        String[] splitLine = line.split("\\|");
        String[] cardAndWinning = splitLine[0].split(":");
        cardNumber = Integer.parseInt(cardAndWinning[0].split("d")[1].trim());
        ArrayList<String> winningNumbers = new ArrayList<>(Arrays.asList(cardAndWinning[1].trim().replaceAll("\\s{2,}", " ").replace(" ", ",").split(",")));
        ArrayList<String> selectedNumbers = new ArrayList<>(Arrays.asList(splitLine[1].trim().replaceAll("\\s{2,}", " ").replace(" ", ",").split(",")));
        winningNumbers.retainAll(selectedNumbers);
        score = winningNumbers.size();
    }
}
