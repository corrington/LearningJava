/*
ProjectEuler.net
Problem 37 - Truncatable primes
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
import static org.apache.commons.math3.primes.Primes.nextPrime;
import static org.apache.commons.math3.primes.Primes.isPrime;

public class Problem037 {

    public static void main(String[] args) {
        var p = new Problem037();

        long sumOfTruncatablePrimes = 0;
        int countOfTruncatablePrimes = 0;

        int n = 11;
        while (countOfTruncatablePrimes < 11) {
        //while (n < 4_000) { // DEBUG
            //System.out.println("n is " + n); // DEBUG
            if (p.isTruncatable(n)) {
                countOfTruncatablePrimes++;
                sumOfTruncatablePrimes += n;
                System.out.println("found one: " + n);  // DEBUG
            } // if

            n = nextPrime(n + 1);

        } // while

        System.out.println("answer is " + sumOfTruncatablePrimes);

    } // main()

    boolean isTruncatable(final int n) {
        if (n < 11) return false;

        int numOfDigits = getNumOfDigits(n);
        // process digits from left to right, for example: 3797, 797, 97, and 7.
        for (int i = numOfDigits; i > 0; i--) {
            int truncated = n % powsOfTen(i);
            if (!isPrime(truncated)) return false;
        } // for i

        // process digits from right to left, for example: 3797, 379, 37, and 3.
        for (int i = 1; i < numOfDigits; i++) {
            int truncated = n / powsOfTen(i);
            if (!isPrime(truncated)) return false;
        } // for i

        return true;

    } //  isTruncatable()


    // reports the number of digits in a number (e.g., 7352 has 4 digits)
    // Taken from https://www.baeldung.com/java-number-of-digits-in-int
    int getNumOfDigits(final int number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    } // getNumOfDigits()


    // just a quick lookup table for the powers of ten.
    // better than calling Math.pow() over an over again for the same ten values
    int powsOfTen( final int exp) {
        if ((exp < 0) || (exp > 9)) {
            throw new IndexOutOfBoundsException("unsupported exponent " + exp);
        } // if
        final int[] table = { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000 };
        return table[exp];
    } // powOfTen()
} // class Problem037
