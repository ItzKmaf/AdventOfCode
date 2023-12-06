package com.kmaf.adventofcode.day3.puzzle1;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
@Log4j2
public class Main {
    private final static String INPUT_FILE_PATH = "src/main/resources/day3/puzzle1/input.txt";

    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!(inputFile.exists() && inputFile.isFile())) {
            log.error("Failed to locate input file at: " + inputFile.getAbsolutePath());
            return;
        }
        try {
            // Scan for Symbols
            Scanner inputFileReader = new Scanner(inputFile);
            int row = 1;
            while (inputFileReader.hasNextLine()) {
                new SymbolScanner(inputFileReader.nextLine(), row);
                row ++;
            }
            inputFileReader.close();
            // Now scan for numbers adjacent to the symbol.
            inputFileReader = new Scanner(inputFile);
            row = 1;
            while (inputFileReader.hasNextLine()) {
                new NumberScanner(inputFileReader.nextLine(), row);
                row ++;
            }
            inputFileReader.close();

            SolutionManger.getInstance().displayResult();
        } catch (FileNotFoundException fnfe) {
            // Do nothing
        }
    }
}
