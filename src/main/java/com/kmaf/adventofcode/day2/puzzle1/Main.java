package com.kmaf.adventofcode.day2.puzzle1;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Log4j2
public class Main {
    private final static String INPUT_FILE_PATH = "src/main/resources/day2/puzzle1/input.txt";
    private final static int MAX_RED = 12;
    private final static int MAX_GREEN = 13;
    private final static int MAX_BLUE = 14;

    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!(inputFile.exists() && inputFile.isFile())) {
            log.error("Failed to locate input file at: " + inputFile.getAbsolutePath());
            return;
        }
        try {
            int figure = 0;
            Scanner inputFileReader = new Scanner(inputFile);
            while (inputFileReader.hasNextLine()) {
                PuzzleLine3 puzzleLine3 = new PuzzleLine3(inputFileReader.nextLine());
                if (puzzleLine3.getFoundRed() > MAX_RED ||
                        puzzleLine3.getFoundGreen() > MAX_GREEN ||
                        puzzleLine3.getFoundBlue() > MAX_BLUE) {
                    continue;
                }
                figure += puzzleLine3.getGameNo();
            }
            log.info("The Sum of gameIDs that fit the criteria is: " + figure);
            System.out.println("The Sum of gameIDs that fit the criteria is: " + figure);
        } catch (FileNotFoundException fnfe) {
            log.error("This is awkward... We tried to read an input file that doesn't exist... How did we get here? -_-");
        }
    }
}