/*
ProjectEuler.net
Problem 9 - Special Pythagorean triplet
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
       a^2 + b^2 = c^2
For example, 32 + 42 = 9 + 16 = 25 = 52.
There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */
public class Problem009 {

    // Notes: this is the brute force method.
    public static long getProductOfSpecialPythagoreanTriplet() {
        final int sumTarget = 1_000;
        for (long a = 1; a <= sumTarget - 2; a++) {
            for (long b = (a + 1); b <= sumTarget - 1; b++) {
                long c = sumTarget - a - b;
                if ((a * a) + (b * b) == (c * c)) {
                    return (a * b * c);
                }
            } // for b
        } // for c
        return 0;
    } // getProductOfSpecialPythagoreanTriplet()

    public static void main(String[] args) {
        System.out.println("answer is " + getProductOfSpecialPythagoreanTriplet());
    } // main()
} // class Problem009
