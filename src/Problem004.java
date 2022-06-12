/*
        ProjectEuler.net
        Problem 4 - Largest palindrome product
        A palindromic number reads the same both ways. The largest palindrome made from the product
        of two 2-digit numbers is 9009 = 91 × 99.
        Find the largest palindrome made from the product of two 3-digit numbers.
         */
public class Problem004 {

    public int reverse(int n) {
        int num = n;
        int numReversed = 0;
        while (num > 0) {
            numReversed = (10 * numReversed) + (num % 10);
            num = num / 10;
        } // while
        return numReversed;
    } // reverse()

    public boolean isPalindrome(int n) {
        return (n == reverse(n));
    } // isPalindrome()

    public int largestPalindromeOfThreeDigitNumbers() {
        int largestPalindrome = 0;
        int a = 999;
        while (a >= 100) {
            int b = 999;
            while (b >= a) {
                if ((a * b) <= largestPalindrome) {
                    break; // because a*b is too small
                }
                if (isPalindrome(a*b)) {
                    largestPalindrome = a*b;
                }
                b--;
            } // while
            a--;
        } // while
        return largestPalindrome;
    } // largestPalindromeOfThreeDigitNumbers()
} // class Problem004