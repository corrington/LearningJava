/*\
ProjectEuler.net
Problem 3 - Largest prime factor
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
 */
import static java.lang.System.*;
//import static org.apache.commons.math3.primes.Primes.*;
// I was going to use the Apache Commons Math library, but was surprised to discover
// it accepts ints instead of longs.  Hmm.  Odd.

public class Problem003 {
    /*
     */
    static long getLargestPrimeFactor( long num) {

        if (num <= 1) return -1;

        long n = num;
        long maxPrime = -1;

        //If num is even, set maxPrime to 2.
        // Keep on dividing num until it's no longer divisible by 2.
        if ((n % 2) == 0) {
            maxPrime = 2;
            while ((n % 2) == 0) {
                n = (n / 2);
            } // while
        } // if

        // At this point, n must be odd.
        // We can skip the even numbers and
        // interrogate only the odd numbers.
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            } // while
        } // for

        // Check if n is in fact a
        // prime number greater than 2
        if (n > 2) {
            maxPrime = n;
        } // if

        return maxPrime;
    } // getLargestPrimeFactor()

    /*
     */
    public static void main(String[] args) {

        long lpf = getLargestPrimeFactor(600_851_475_143L);
        System.out.println("Largest prime factor is " + lpf);

    } // main()

} // class Problem003