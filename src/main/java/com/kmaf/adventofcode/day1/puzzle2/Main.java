package com.kmaf.adventofcode.day1.puzzle2;



import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class Main {

    private final static String INPUT_FILE_PATH = "src/main/resources/day1/puzzle1/input.txt";
    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!(inputFile.exists() && inputFile.isFile())) {
            log.error("Failed to locate input file at: " + inputFile.getAbsolutePath());
            return;
        }
        try {
            AtomicInteger figure = new AtomicInteger();
            Scanner inputFileReader = new Scanner(inputFile);
            inputFileReader.forEachRemaining((String line) -> {
                PuzzleLine puzzleLine = new PuzzleLine(line);
                figure.set(figure.get() + (puzzleLine.getFirstNum() * 10) + puzzleLine.getLastNum());
            });
            log.info("The Calibration figure is: " + figure);
            System.out.println("The Calibration figure is: " + figure);
        } catch (FileNotFoundException fNFE) {
            log.error("This is awkward... We tried to read an input file that doesn't exist... How did we get here? -_-");
        }
    }
}
