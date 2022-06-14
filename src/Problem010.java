/*
ProjectEuler.net
Problem 10 - Summation of primes
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
 */
import static org.apache.commons.math3.primes.Primes.*;

public class Problem010 {
    public long getSumOfPrimes( int maxN ) {
        long sumOfPrimes = 0;
        int prime = 2;
        do {
            sumOfPrimes += prime;
            prime = nextPrime(prime + 1);
        } while (prime < maxN);
        return sumOfPrimes;
    } // getSumOfPrimes()
} // class Problem010
