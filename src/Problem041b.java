/*
ProjectEuler.net
Problem 41 - Pandigital prime
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 */
import static org.apache.commons.math3.primes.Primes.isPrime;

public class Problem041b {

    public static void main(String[] args) {
        /*
        This is a brute force method that simply checks all of the numbers in the specified range
        to determine if they are pandigital and prime
         */

        final int minN = 7123456;
        final int maxN = 7654321;
        int candidate = maxN;

        while (candidate > minN) {
            if (isPandigital(candidate) && isPrime(candidate)) {
                System.out.println("answer is " + candidate);
                break;
            } // if
            candidate -= 2;
        } // while

    } // main()


    static boolean isPandigital(final long candidate) {
        // look at each digit in the number
        // note its presence in the array of booleans, using the digit as the index
        // for example if number was "13579", resulting array would be {f,t,f,t,f,t,f,t,f,t}
        //                                                              0,1,2,3,4,5,6,7,8,9
        if (candidate == 1) return true;
        if (candidate < 10) return false;

        long n = candidate;
        boolean[] digitsPresent = new boolean[10];
        int numOfDigits = 0;
        while (n > 0) {
            int digit = (int)(n % 10L);
            digitsPresent[digit] = true;
            n = n / 10L;
            numOfDigits++;
        } // while

        // to be pandigital, every digit must have been present.
        // if any are missing, we're done.
        for (int digit = 1; digit <= numOfDigits; digit++) {
            if (!digitsPresent[digit]) return false;
        } // for

        return true;

    } // isPandigital()


} // class Problem041b
