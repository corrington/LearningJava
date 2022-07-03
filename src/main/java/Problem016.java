/*
ProjectEuler.net
Problem 16 - Power digit sum
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
What is the sum of the digits of the number 21000?
 */
import java.math.BigInteger;

public class Problem016 {

    public static void main(String[] args) {

        BigInteger bigNum = new BigInteger("2").pow(1000);

        System.out.println(sumOfDigits(bigNum));

    } // main()

    private static int sumOfDigits(BigInteger bigNum) {
        int sum = 0;

        // convert big integer to an array of characters
        char[] digits = bigNum.toString().toCharArray();

        // visit every char, convert it to a digit, then add them up
        for (char digit : digits) {
            sum += Character.getNumericValue(digit);
        }

        return sum;

    } // sumOfDigits()

} // class Problem016