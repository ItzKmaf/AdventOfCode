package com.kmaf.adventofcode.day4.puzzle2;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Log4j2
public class PuzzleManager {

    private final static String INPUT_FILE_PATH = "src/main/resources/day4/puzzle1/input.txt";
    private static PuzzleManager instance;
    private final ArrayList<PuzzleLine> puzzleLines = new ArrayList<>();

    private int totalScore = 0;

    private PuzzleManager() {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!(inputFile.exists() && inputFile.isFile())) {
            log.error("Failed to locate input file at: " + inputFile.getAbsolutePath());
            throw new IllegalArgumentException("Puzzle Input file at path: " + inputFile.getAbsolutePath() + " does not exist.");
        }

        try {
            Scanner inputFileReader = new Scanner(inputFile);
            while (inputFileReader.hasNextLine()) {
                puzzleLines.add(new PuzzleLine(inputFileReader.nextLine()));
            }

            for (PuzzleLine puzzleLine: puzzleLines) {
                computeOccurrences(puzzleLine);
            }
            System.out.println(totalScore);

        } catch (FileNotFoundException fNFE) {
            throw new IllegalArgumentException("Puzzle Input file could not be found: " + inputFile.getAbsolutePath());
        }

    }

    public static PuzzleManager getInstance() {
        if (instance == null) {
            instance = new PuzzleManager();
        }
        return instance;
    }

    public void computeOccurrences(PuzzleLine puzzleLine) {
        totalScore ++;
        for (int x = puzzleLine.getCardNumber(); ((x < puzzleLine.getCardNumber() + puzzleLine.getScore()) && (x < puzzleLines.size())); x++) {
            computeOccurrences(puzzleLines.get(x));
        }
    }
}
