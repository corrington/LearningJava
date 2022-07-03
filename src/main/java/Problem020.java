/*
ProjectEuler.net
Problem 20 - Factorial digit sum
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */
import java.math.BigInteger;

public class Problem020 {

    // copied from Problem 16
    private static int sumOfDigits(BigInteger bigNum) {
        int sum = 0;

        // convert big integer to an array of characters
        char[] digitChars = bigNum.toString().toCharArray();

        // visit every char, convert it to a digit, then add them up
        for (char digit : digitChars) {
            sum += Character.getNumericValue(digit);
        } // for digit

        return sum;

    } // sumOfDigits()

    public static void main(String[] args) {

        // calculate 100!
        BigInteger factorial = new BigInteger("100");
        for (int n = 100; n > 1; n--) {
            factorial = factorial.multiply(new BigInteger("" + (n - 1)));
        } // for n

        System.out.println("100! is " + factorial);
        System.out.println("the sum of the digits is " + sumOfDigits(factorial));

    } // main()

} // class Problem020
