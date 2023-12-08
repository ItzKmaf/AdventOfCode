package com.kmaf.adventofcode.day4.puzzle1;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Log4j2
public class PuzzleManager {

    private final static String INPUT_FILE_PATH = "src/main/resources/day4/puzzle1/input.txt";
    private static PuzzleManager instance;

    private PuzzleManager() {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!(inputFile.exists() && inputFile.isFile())) {
            log.error("Failed to locate input file at: " + inputFile.getAbsolutePath());
            throw new IllegalArgumentException("Puzzle Input file at path: " + inputFile.getAbsolutePath() + " does not exist.");
        }

        try {
            Scanner inputFileReader = new Scanner(inputFile);
            ArrayList<PuzzleLine> puzzleLines = new ArrayList<>();
            while (inputFileReader.hasNextLine()) {
                puzzleLines.add(new PuzzleLine(inputFileReader.nextLine()));
            }

            int result = 0;
            for (PuzzleLine puzzleLine: puzzleLines) {
                puzzleLine.getWinningNumbers().retainAll(puzzleLine.getSelectedNumbers());
                result += (int) Math.pow(2, puzzleLine.winningNumbers.size() -1);
            }

            System.out.println(result);

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
}
