/*
ProjectEuler.net
Problem 47 - Distinct primes factors
https://projecteuler.net/problem=47

The first two consecutive numbers to have two distinct prime factors are:

    14 = 2 × 7
    15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

    644 = 2² × 7 × 23
    645 = 3 × 5 × 43
    646 = 2 × 17 × 19

Find the first four consecutive integers to have four distinct prime factors each.
What is the first of these numbers?

 */
import java.util.List;
import java.util.HashSet;
import static org.apache.commons.math3.primes.Primes.primeFactors;

public class Problem047 {
    // The Apache Commons primeFactors() returns an array of integers containing
    // all the prime factors, for example: pf(648) = {2,2,2,3,3,3,3}.
    // To quickly remove the duplicates, I add the list to a HashSet.
    // Then return the unique prime factors, for example: upf(648) = {2,3}
    HashSet<Integer> getUniquePrimeFactors(final int n) {
        List<Integer> primeFactors = primeFactors(n);
        HashSet<Integer> uniquePrimeFactors = new HashSet<>(primeFactors);
        return uniquePrimeFactors;
    } // getUniquePrimeFactors()

    // For n and the next three numbers, get the unique prime factors and ensure there are four.
    boolean IsMagicalNumber(final int n) {
        HashSet<Integer> uniquePrimeFactors;
        for (int i = 0; i < 4; i++) {
            uniquePrimeFactors = getUniquePrimeFactors(n + i);
            if (uniquePrimeFactors.size() != 4) return false;
        } // for i
        return true;
    } // IsMagicalNumber()

    public static void main(String[] args) {
        var p = new Problem047();
        int n = 644;
        while (!p.IsMagicalNumber(n)) {
            n++;
        } // while
        System.out.println("answer is " + n);
    } // main()
} // class Problem047
