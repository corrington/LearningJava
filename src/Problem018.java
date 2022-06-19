/*
ProjectEuler.net
Problem 18 - Maximum path sum I
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

   3
  7 4
 2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

                     75
                   95 64
                  17 47 82
                18 35 87 10
               20 04 82 47 65
             19 01 23 75 03 34
            88 02 77 73 07 63 67
          99 65 04 28 06 16 70 92
         41 41 26 56 83 40 80 70 33
       41 48 72 33 47 32 37 16 94 29
      53 71 44 65 25 43 91 52 97 51 14
    70 11 33 28 77 73 17 78 39 68 17 57
   91 71 52 38 17 14 91 43 58 50 27 29 48
 63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 */

import java.lang.Math;

public class Problem018 {
    /*
     We're going to work the triangle from bottom to top, and left to right.
     Using the sample triangle, we'll start with the second to last row (e.g., 2,4,6)
     First, we add 2 to its left child (2+8), then add 2 to its right child (2+5).
     Next, we stuff the larger sum (10) into 2's cell. Then we move right on to the next column.
     After processing all the nodes on the row, we move up a row and repeat the process.
     By the time we're done, the max total is in the [0][0] node.
    */

    private static int getMax(final int[][] triangle, final int row, final int col) {
        // Add the value of the parent element to its left child
        int leftPair = triangle[row][col] + triangle[row+1][col];
        // Add the value of the parent element to its right child
        int rightPair = triangle[row][col] + triangle[row+1][col+1];
        // and return the bigger of the two sums
        return Math.max(leftPair, rightPair);
    } // getMax()

    private static int getMaxTotal(final int[][] triangle) {

        final int maxRow = triangle.length;          // get the number of rows

        // starting at the second to last row in the triangle...
        for (int row = maxRow - 2; row >= 0; row--) {
            // add each the value of each element to its left and right children
            for (int col = 0; col < triangle[row].length; col++) {
                // take the bigger sum and stuff it into the current element,
                triangle[row][col] = getMax(triangle, row, col);
            } // for col
        } // for row

        // by the time we get here, the maximum total is at the top of the triangle
        return triangle[0][0];

    } // getMaxTotal()


    public static void main(String[] args) {
        int[][] triangle1 = {
                {3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };

        int[][] triangle2 = {
                {75},
                {95,64},
                {17,47,82},
                {18,35,87,10},
                {20, 4,82,47,65},
                {19, 1,23,75, 3,34},
                {88, 2,77,73, 7,63,67},
                {99,65, 4,28, 6,16,70,92},
                {41,41,26,56,83,40,80,70,33},
                {41,48,72,33,47,32,37,16,94,29},
                {53,71,44,65,25,43,91,52,97,51,14},
                {70,11,33,28,77,73,17,78,39,68,17,57},
                {91,71,52,38,17,14,91,43,58,50,27,29,48},
                {63,66, 4,68,89,53,67,30,73,16,69,87,40,31},
                { 4,62,98,27,23, 9,70,98,73,93,38,53,60, 4,23}
        };

                System.out.println("answer is " + getMaxTotal(triangle1));
                System.out.println("answer is " + getMaxTotal(triangle2));

    } // main()
} // class Problem018
