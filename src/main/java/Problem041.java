/*
ProjectEuler.net
Problem 41 - Pandigital prime

We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 */
import static org.apache.commons.math3.primes.Primes.isPrime;

public class Problem041 {

    public static void main(String[] args) {
        /*
         Uses the SEPA permutations algorithm from Problem 24 to find the pandigital combinations,
         then checks each one to see if it's a prime
         */
        var p24 = new Problem024();

        int[] digits = {1, 2, 3, 4, 5, 6, 7};
        int largestPrime = 0;

        while (p24.findNext(digits)) {
            if (isPrime(arrayToInt(digits))) {
                int candidate = arrayToInt(digits);
                largestPrime = Math.max(candidate,largestPrime);
            } // if
        } // while

        System.out.println("answer is " + largestPrime);

    } // main()

    private static int arrayToInt(final int[] digits) {
        // converts an array of digits back to an int going left-to-right
        int result = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            result = (result * 10) + digits[i];
        } // for i
        return result;
    } // arrayToInt()

} // class Problem041
