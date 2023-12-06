package com.kmaf.adventofcode.day3.puzzle2;

import lombok.Getter;

@Getter
public class FileLine {

    private final String line;
    private final int lineNumber;
    public FileLine(String line, int lineNumber) {
        this.line = line;
        this.lineNumber = lineNumber;
    }
}
