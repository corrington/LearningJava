import static org.apache.commons.math3.util.CombinatoricsUtils.factorial;

public class Problem034 {

    // It seemed a little silly to recalculate the factorial of the same ten digits over and over again.
    // I created a ten-element array so I could calc the values once and then quickly look them up over and over again.
    private final static long[] factorialOfDigitTable = new long[10];

    public Problem034() {
        // create and populate the lookup table when the object is created.
        populateFactorialLookupTable();
    } //  Problem034()

    public static void main(String[] args) {
        var p = new Problem034();

        System.out.println("answer is " + p.getSumOfAllMagicalNumbers());

    } // main()

    private void populateFactorialLookupTable() {
        for (int n = 0; n < factorialOfDigitTable.length; n++) {
            factorialOfDigitTable[n] = factorial(n);
        } // for n
    } // populateFactorialLookupTable()

    // rather than cacl the factorial over and over again, simply pull it out of a lookup table
    long factorialOfDigit(final int n) {
        return factorialOfDigitTable[n];
    } // factorialOfDigit

    // convert an int into an int array of digits.
    // n = 123 becomes int[] = {1,2,3}
    int[] toDigitArray(final int n) {

        // convert the number to a string
        String str = "" + n;
        int len = str.length();

        // convert the string to a char array of digits
        char[] digitCharArray = str.toCharArray();

        // convert the char array of digits to an int array of digits
        int[] digitArray = new int[len];
        for (int i = 0; i < len; i++) {
            digitArray[i] = digitCharArray[i] - '0';
        }  // for i

        return digitArray;

    } // toDigits()

    int getSumOfAllMagicalNumbers() {

        final int maxN = 50_000;            // the magical upperbound

        int sumOfAllMagicalNumbers = 0;

        // run through the numbers
        for (int n = 3; n < maxN; n++) {
            // get the individual digits of the current number
            int[] digits = toDigitArray(n);

            // calc the sum of the factorial of each digit in the number
            long sumOfDigitFactorials = 0;
            for (int digit : digits) {
                sumOfDigitFactorials += factorialOfDigit(digit);
                // does sum of the digit factorials equal our current number?
                if (n == sumOfDigitFactorials) {
                    sumOfAllMagicalNumbers += n;
                }
            } // for i

        } // for n
        return sumOfAllMagicalNumbers;
    } // getSumOfAllMagicalNumbers()
} // class Problem034
