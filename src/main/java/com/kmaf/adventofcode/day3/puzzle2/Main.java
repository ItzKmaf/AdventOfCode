package com.kmaf.adventofcode.day3.puzzle2;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        ArrayList<FileLine> fileLines = new ArrayList<>();
        try {
            // Scan for Symbols
            Scanner inputFileReader = new Scanner(inputFile);
            int row = 1;
            while (inputFileReader.hasNextLine()) {
                FileLine fileLine = new FileLine(inputFileReader.nextLine(), row);
                fileLines.add(fileLine);
                new SymbolScanner(fileLine.getLine(), fileLine.getLineNumber());
                row ++;
            }
            inputFileReader.close();
            // Now scan for numbers adjacent to the symbol.
            FileLine line1;
            FileLine line2 = null;
            FileLine line3 = null;
            for (FileLine fileLine: fileLines) {
                line1 = line2;
                line2 = line3;
                line3 = fileLine;
                new NumberScanner(line1, line2, line3);
            }
            SolutionManger.getInstance().displayResult();
        } catch (FileNotFoundException fnfe) {
            // Do nothing
        }
    }
}
