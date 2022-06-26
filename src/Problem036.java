/*
ProjectEuler.net
Problem 36 - Double-base palindromes
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
 */

public class Problem036 {

    public static void main(String[] args) {
        // even numbers cannot be a palindrome in base two.
        // so, we're only checking the odd numbers
        var p = new Problem036();
        int sum = 0;
        for (int n = 1; n < 1_000_000; n += 2) {
            if (p.isPalindrome(n,10) && p.isPalindrome(n,2)) {
                sum += n;
            } // if
        } // for n

        System.out.println("answer is " + sum);

    } //  main()

    int reverseNumber(final int n, final int base) {
        int reversed = 0;
        int working = n;
        while (working > 0) {
            reversed = (reversed * base) + (working % base);
            working = working / base;
        } // while
        return reversed;
    } // reverseNumber()

    boolean isPalindrome(final int n, final int base) {
        return n == reverseNumber(n,base);
    } // isPalindrome()
} // class Problem036
