/*
ProjectEuler.net
Problem 1 - Multiples of 3 or 5
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem001 {
    public static void main(String[] args) {
        int sumOfMultiples = 0;
        for (int n = 3; n < 1_000; n++) {
            if (((n % 3) == 0) || ((n % 5) == 0)) {
                sumOfMultiples += n;
            } // if
        } // for i
        System.out.println("answer is " + sumOfMultiples);
    } // main()
} // class Problem001
