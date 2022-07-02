/*
ProjectEuler.net
Problem 24 - Lexicographic permutations
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation
of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem024 {

    public static void main(String[] args) {

        var p24 = new Problem024();

        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 1; i < 1_000_000; i++) {
            p24.findNext(digits);
        } // for i

        System.out.print("answer is ");
        for (int digit : digits) {
            System.out.print(digit);
        } // for
        System.out.println();

    } // main()

    // find the next sorted order permutation using the SEPA algorithm
    // https://www.quickperm.org/soda_submit.php
    public boolean findNext(int[] digits) {
        int len = digits.length;
        int key = digits.length - 1;

   /* The key value is the first value from the end which
      is smaller than the value to its immediate right        */

        while ((key > 0) && (digits[key - 1] > digits[key])) {
            key--;
        } // while

        key--;

   /* If key < 0 the data is in reverse sorted order,
      which is the last permutation.                          */

        if (key < 0) return false;

   /* digits[key+1] is greater than digits[key] because of how key
      was found. If no other is greater, digits[key+1] is used   */

        int newKey = len - 1;
        while ((newKey > key) && (digits[key] > digits[newKey])) {
            newKey--;
        } //while

        swap(digits, key, newKey);


   /* Finally, the tail must be in sorted order to produce the next permutation.
      So we walk through the tail exchanging pairs from both ends of the tail.
    */
        int tailStart = key + 1;
        int tailEnd = len - 1;

        while (tailEnd > tailStart) {
            swap(digits, tailStart, tailEnd);
            tailStart++;
            tailEnd--;
        } // while

        return true;

    } // findNext()

    private void swap(int[] digits, final int left, final int right) {
        int temp = digits[left];
        digits[left] = digits[right];
        digits[right] = temp;
    } // swap

} // class Problem024
