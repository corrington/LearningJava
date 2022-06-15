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

After coding the brute-force method and reading the solution PDF provided by ProjectEuler.net, I decided to
implement one of their optimizations: store and lookup previously calculated Collatz's values and terms.
At first, I thought of using an int array, but int arrays cannot use longs for an index.
Next, I thought of using a hash map. The standard Java HashMap does not store primitives
(e.g., longs and ints), only Objects. I didn't want the hassle or overhead of converting back and forth
between primitive data types and Objects.
So, I decided to use the LongIntHashMap offered by the Eclipse Collection.
The version without a hash map completed in 0.37 seconds.
The version using a hash map completed in 0.91 seconds.  Hahahahah.
Setting the initial capacity of the hash map didn't help much. It completed in 0.72 seconds.
 */

import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;

public class Problem014b {


    public static void main(String[] args) {

        var sw = new Stopwatch();

        var lookupTable = new LongIntHashMap(1_000_000);  // <key is the Collatz, value is the number of terms>

        long maxValue = 0;
        int maxTerms = 0;

        for ( long currValue = 1; currValue < 1_000_000  ; currValue++) {

            long n = currValue;
            int currTerms = 1;
            do {

                if (lookupTable.containsKey(currValue)) { // have we seen this number before?
                    // If so, we don't need to run through the Collatz formulas again.
                    // Just return the previously calculated number of terms and move on.
                    currValue = 1;
                    currTerms = lookupTable.get(currValue);
                } else {  // if not, calculate the next term in the sequence
                    if (n % 2 == 0) {   // is even
                        n = n / 2;
                    } else { // is odd
                        n = 3 * n + 1;
                    } // if
                    currTerms++;
                }
            } while (n > 1);

            // System.out.print(n);   // DEBUG

            if (!lookupTable.containsKey(currValue)) {
                lookupTable.put(currValue, currTerms);
            }

            if (currTerms > maxTerms) {
                maxValue = currValue;
                maxTerms = currTerms;
            } // if

        } // for

        System.out.println("elapse time: " + sw.elapsedTime() );
        System.out.println("answer is " + maxValue + " with " + maxTerms + " terms.");
        System.out.println("number of hash map entries is " + lookupTable.size());
        //System.out.println("lookupTable is:" + lookupTable);
    } // main()

} // class Problem014b
