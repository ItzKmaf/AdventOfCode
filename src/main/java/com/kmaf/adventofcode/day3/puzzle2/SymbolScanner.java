package com.kmaf.adventofcode.day3.puzzle2;

public class SymbolScanner {
    private final static String VALID_SYMBOLS = "*";

    public SymbolScanner(String lineToScan, int lineIndex) {
        int column = 0;
        for (char lineChar: lineToScan.toCharArray()) {
            String character = Character.toString(lineChar);
            if (VALID_SYMBOLS.contains(character)) {
                // This is a valid symbol.
                onDetectedSymbol(lineIndex, column);
            }
            column ++;
        }
    }

    /**
     * Registers a box of coords around a given symbol similar to below.
     * XXX
     * X@X
     * XXX
     * @param row the row of the detected symbol
     * @param column the column of the detected symbol
     */
    private static void onDetectedSymbol(int row, int column) {
        CoordManager coordManager = CoordManager.getInstance();
        coordManager.addCoord(row, column);
    }
}
