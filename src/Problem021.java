/*
ProjectEuler.net
Problem 21 - Amicable numbers
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */


public class Problem021 {

    // code copied from https://www.geeksforgeeks.org/sum-factors-number/ written by DevanshuAgarwal
    // Function to calculate sum of all proper
    // divisors num --> given natural number
    static int divSum(int num)
    {
        // Final result of summation of divisors
        int result = 0;

        // find all divisors which divides 'num'
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            // if 'i' is divisor of 'num'
            if (num % i == 0)
            {
                // if both divisors are same then
                // add it only once else add both
                if (i == (num / i))
                    result += i;
                else
                    result += (i + num / i);
            }
        }

        // Add 1 to the result as 1 is also
        // a divisor
        return (result + 1);
    }


    public static void main(String[] args) {

        System.out.println(divSum(220));
        System.out.println(divSum(284));

    } // main()
} // class Problem021
