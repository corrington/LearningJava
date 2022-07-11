/*
ProjectEuler.net
Problem 14 - Longest Collatz sequence
The following iterative sequence is defined for the set of positive integers:

      n → n/2 (n is even)
      n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

      13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?
NOTE: Once the chain starts the terms are allowed to go above one million.

Notes: Yes, this brute-force solution overflows the Java int datatype.
And Java does NOT throw an exception when an int overflows. Had to use the long datatype.
However, the number of terms easily fits within the int datatype.
 */
import com.corrington.Stopwatch;

public class Problem014 {

    public static void main(String[] args) {

        Stopwatch sw = new Stopwatch();

        long maxValue = 0;
        int maxTerms = 0;

        for ( long currValue = 1; currValue < 1_000_000; currValue++) {

            long n = currValue;
            int currTerms = 1;
            do {
                // System.out.print(n + " -> ");  // DEBUG
                if (n % 2 == 0) {   // is even
                    n = n / 2;
                } else { // is odd
                    n = 3 * n + 1;
                } // if
                currTerms++;
            } while (n > 1);

            // System.out.print(n);   // DEBUG

            if (currTerms > maxTerms) {
                maxValue = currValue;
                maxTerms = currTerms;
            } // if

        } // for

        System.out.println("answer is " + maxValue + " with " + maxTerms + " terms.");
        System.out.println("elapse time: " + sw.elapsedTime() );

    } // main()

} // class Problem014
