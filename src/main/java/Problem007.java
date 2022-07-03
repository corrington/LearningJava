/*
ProjectEuler.net
Problem 7 - 10001st prime
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10 001st prime number?
 */
import static org.apache.commons.math3.primes.Primes.*;

public class Problem007 {
    /*
    Note: I could have written an isPrime() function, but thought it would be faster and more interesting
    to learn how to import and use the Apache Commons Math library.
     */
    public int getNthPrime(int count) {
            int prime = 1;
            for (int c = 1; c <= count; c++) {
                prime = nextPrime(prime+1);
            } // for n
            return prime;
        } // getNthPrime()
} // class Problem007
