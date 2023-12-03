package com.kmaf.adventofcode.day2.puzzle2;

import lombok.Getter;

@Getter
public class PuzzleLine {

    private final int gameNo;
    private int foundRed;
    private int foundGreen;
    private int foundBlue;

    public PuzzleLine(String line) {
        String[] lineSplit = line.split(":");
        // Get the game no
        gameNo = Integer.parseInt(lineSplit[0].split(" ")[1]);
        // Get the list of bag reaches
        String[] bagReaches = lineSplit[1].split(";");
        // For each of the times the bag was reached into
        for (String reach: bagReaches) {
            // Split each bag reach into its individual colors
            String[] colours = reach.split(",");
            // For each of the colors in the bag reach
            for (String colorString: colours) {
                // Split the number of colors pulled from the name of the color
                String[] colorPull = colorString.trim().split(" ");
                int count = Integer.parseInt(colorPull[0]);
                String color = colorPull[1];
                // Find the exact color and, if the value pulled is bigger than the value stored, increment it.
                switch (color) {
                    case "red": {
                        foundRed = Math.max(count, foundRed);
                        break;
                    }
                    case "green": {
                        foundGreen = Math.max(count, foundGreen);
                        break;
                    }
                    case "blue": {
                        foundBlue = Math.max(count, foundBlue);
                        break;
                    }
                }

            }
        }
    }
}
