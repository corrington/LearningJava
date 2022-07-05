/*
ProjectEuler.net
Problem 45 - Triangular, pentagonal, and hexagonal
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n−1)/2	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...

It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.

Note: In my previous solution, I didn't notice every hexagonal number is also a triangular number.
So, we only need to check pentagonal and hexagonal numbers, which makes for cleaner, simpler code.
*/
public class Problem045b {

    private static long nextPentagonal(final int n) {
        return (n * (3L * n - 1L)) / 2L;
    } // nextPentagonal()

    private static long nextHexagonal(final int n) {
        return n * (2L * n - 1L);
    } // nextHexagonal()

    public static void main(String[] args) {

        int pentagonalIndex = 166;
        long pentagonalValue = nextPentagonal(pentagonalIndex);

        int hexagonalIndex = 143;
        long hexagonalValue = nextHexagonal(hexagonalIndex);

        // loop around and around, bumping up the smallest value, until all three values are equal
        while (pentagonalValue != hexagonalValue) {

            if (pentagonalValue < hexagonalValue) {
                pentagonalIndex++;
                pentagonalValue = nextPentagonal(pentagonalIndex);
            } else {
                hexagonalIndex++;
                hexagonalValue = nextHexagonal(hexagonalIndex);
            } // if

        } // while

        System.out.println("answer is " + pentagonalValue);

    } // main()
} // class Problem045b
