package com.corrington;

public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        int[][] board = {
                {0,3,0,  6,0,0,  4,0,0},
                {0,0,0,  0,0,0,  0,6,0},
                {0,0,0,  0,0,9,  0,0,8},

                {0,0,1,  0,2,6,  0,4,0},
                {3,0,0,  0,5,0,  7,0,0},
                {2,0,6,  0,0,3,  0,0,1},

                {0,8,0,  1,9,0,  0,0,0},
                {0,0,5,  3,4,0,  0,0,7},
                {4,2,7,  0,0,0,  9,0,0}
        };


        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("Solved");
        }
        else {
            System.out.println("Unsolvable");
        }

        printBoard(board);

    } // main()


    private static void printBoard(final int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("----+-----+----");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print(" | ");
                }
                System.out.print(board[row][column]);
            } // for col
            System.out.println();
        } // for row
        System.out.println();
    } // printBoard()


    private static boolean isNumberInRow(final int[][] board, final int row, final int number) {
        for (int column = 0; column < GRID_SIZE; column++) {
            if (board[row][column] == number) {
                return true;
            }
        }  // for column
        return false;
    } // isNumberInRow()

    private static boolean isNumberInColumn(final int[][] board, final int column, final int number) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (board[row][column] == number) {
                return true;
            }
        } // for row
        return false;
    } // isNumberInRow()

    private static boolean isNumberInBox(final int[][] board, final int row, final int column, final int number) {
        final int localBoxRow = row - row % 3;
        final int localBoxColumn = column - column % 3;

        for (int r = localBoxRow; r < localBoxRow + 3; r++) {
            for (int c = localBoxColumn; c < localBoxColumn + 3; c++) {
                if (board[r][c] == number) {
                    return true;
                }
            } // for c
        } // for r
        return false;
    } // isNumberInBox()

    private static boolean isValidPlacement(final int[][] board, final int row, final int column, final int number) {
        return !isNumberInRow(board, row, number) &&
                !isNumberInColumn(board, column, number) &&
                !isNumberInBox(board, row, column, number);
    } // isValidPlacement()

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                // if the cell is empty,...
                if (board[row][column] == 0) {
                    // ... try every possible number to see if any work.
                    for (int candidate = 1; candidate <= GRID_SIZE; candidate++) {
                        if (isValidPlacement(board, row, column, candidate)) {
                            board[row][column] = candidate;

                            // use recursion to keep going...
                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                // well, that didn't work, so we need to back up and try a different number
                                board[row][column] = 0;
                            }
                        }
                    } // for candidate
                    // none of the candidates worked, which means we need to back up and try again.
                    return false;
                }
            } // for column
        } // for row
        // if we got here, all of the candidates worked. we're done.
        return true;
    } // solveBoard

} // class SudokuSolver