package com.kmaf.adventofcode.day2.puzzle2;

import com.kmaf.adventofcode.day2.puzzle1.PuzzleLine;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Log4j2
public class Main {
    private final static String INPUT_FILE_PATH = "src/main/resources/day2/puzzle1/input.txt";
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
                PuzzleLine puzzleLine = new PuzzleLine(inputFileReader.nextLine());
                figure += puzzleLine.getFoundRed() * puzzleLine.getFoundBlue() * puzzleLine.getFoundGreen();
            }
            log.info("The total power of the cubes played in all games is: " + figure);
            System.out.println("The total power of the cubes played in all games is: " + figure);
        } catch (FileNotFoundException fnfe) {
            log.error("This is awkward... We tried to read an input file that doesn't exist... How did we get here? -_-");
        }
    }
}