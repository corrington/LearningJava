/*
ProjectEuler.net
Problem 30 - Digit fifth powers

Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
import java.lang.Math;

public class Problem030 {

    public static int sumOfFifthPowers() {
        // Raising the same ten digits to the fifth over and over again using Math.pow() is inefficient.
        // Instead, I'll generate and use a quick lookup table.
        int[] fifthOf = new int[10];
        for (int i = 0; i < fifthOf.length; i++) {
            fifthOf[i] = (int)Math.pow(i,5);
        } // for i

        int sum = 0;
        final int maxN = (int)(6.0 * Math.pow(9,5));   // this is our upperbound

        for (int n = 2; n <= maxN; n++) {
            int d1s = n % 10;                       // peal off the digit in the ones column
            int d10s = (n % 100) / 10;              // peal off the digit in the tens column
            int d100s = (n % 1_000) / 100;          // peal off the digit in the hundreds column
            int d1_000s = (n % 10_000) / 1_000;     // peal off the digit in the hundreds column
            int d10_000s = (n % 100_000) / 10_000;  // peal off the digit in the ten-thousands column
            int d100_000s = n / 100_000;            // peal off the digit in the hundred-thousands column

            int candidate = fifthOf[d100_000s] + fifthOf[d10_000s] + fifthOf[d1_000s] + fifthOf[d100s] + fifthOf[d10s] + fifthOf[d1s];

            if (n == candidate) {
                System.out.println("term is " + n);
                sum += n;
            } // if

        } // for n

        return sum;

    } // sumOfFifthPowers()

    public static void main(String[] args) {
        int sum = sumOfFifthPowers();
        System.out.println("sum of fifth powers is " + sum);
    } // main()

} // class Problem030
