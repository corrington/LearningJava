public class Problem043 {

    // Summary: generate all the combinations and test them
    public static void main(String[] args) {

        var p43 = new Problem043();
        /*
            Using the SEPA permutations algorithm from Problem 24 to find the pandigital combinations,
            then checks each one to see if it's a prime
        */
        var p24 = new Problem024();

        long sum = 0;

        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        while (p24.findNext(digits)) {
            if (p43.isHighlyDivisiblePandigital(digits)) {
                sum += p43.digitsToNumber(digits);
            } // if
        } // while

        System.out.println("answer is " + sum);

    } // main()

    boolean isHighlyDivisiblePandigital(final int[] digits) {
        // first, we'll perform some quick checks that help prevent us from doing conversions later.
        // The first digit must be non-zero, otherwise it's not a "0 to 9 pandigital number"
        if (digits[0] == 0) return false;
        // The forth digit must be even {0,2,4,6,8}
        if ((digits[3] % 2) != 0) return false;
        // The fifth digit must be {0,5}
        if (!((digits[5] == 0) || (digits[5] == 5))) return false;

        // Now we convert substrings of the digits and test them.
        // We're processing them from right-to-left
        int n = digitsToNumber(digits, 7, 9);
        if (n % 17 != 0) return false;

        n = digitsToNumber(digits, 6, 8);
        if (n % 13 != 0) return false;

        n = digitsToNumber(digits, 5, 7);
        if (n % 11 != 0) return false;

        n = digitsToNumber(digits, 4, 6);
        if (n % 7 != 0) return false;

        n = digitsToNumber(digits, 2, 4);
        if (n % 3 != 0) return false;

        return true;

    } // isHighlyDivisiblePandigital()

    long digitsToNumber(final int[] digits) {
        // converts an array of digits back to a long going right-to-left
        long result = 0L;
        for (int digit : digits) {
            result = (result * 10L) + (long) digit;
        } // for i
        return result;
    } // digitsToNumber()


    int digitsToNumber(final int[] digits, final int starting, final int ending) {
        // converts a substring of digits back to an int going right-to-left
        int result = 0;
        for (int i = starting; i <= ending; i++) {
            result = (result * 10) + digits[i];
        } // for i
        return result;
    } // digitsToNumber()

} // class Problem043
