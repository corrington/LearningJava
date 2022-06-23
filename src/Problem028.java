/*
ProjectEuler.net
Problem 28 - Number spiral diagonals
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */

public class Problem028 {
    static long sumSpiralDiagonals(final int maxRows) {

        if (maxRows == 1) return 1;

        long grandTotal = 1L;
        long nextCorner = 1L;
        for (int r = 3; r <= maxRows; r += 2) {

            int delta = (r - 1);
            long startingCorner = nextCorner + delta;
            for (int c = 0; c < 4; c++) {
                nextCorner = startingCorner + (long)delta * c;
                // System.out.println("corner is " + nextCorner); // DEBUG
                grandTotal += nextCorner;
            } // for c

        } // for r

        return grandTotal;

    } // sumSpiralDiagonals()

    public static void main(String[] args) {
        final int rows = 1001;  // must be an odd number
        System.out.println("answer is " + sumSpiralDiagonals(rows));
    } // main()

} // class Problem028
