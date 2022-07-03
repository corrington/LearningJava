/*
ProjectEuler.net
Problem 5 - Smallest Multiple
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem005 {

    /*
    Notes: this is a brute force method with only a small handful of minor optimizations.
    We know the number has to be even, because it must be divisible by two.
    Since it has to be divisible by twenty, we can increment by twenty each loop.
    If a number is divisible by twenty, it's also divisible by ten.
     */
    public static long SmallestMultiple() {
        long candidate = 2520;
        while (true) {
            candidate += 20;
            //if (candidate % 2 != 0) continue;
            if (candidate % 3 != 0) continue;
            if (candidate % 4 != 0) continue;
            if (candidate % 5 != 0) continue;
            if (candidate % 6 != 0) continue;
            if (candidate % 7 != 0) continue;
            if (candidate % 8 != 0) continue;
            if (candidate % 9 != 0) continue;
            //if (candidate % 10 != 0) continue;
            if (candidate % 11 != 0) continue;
            if (candidate % 12 != 0) continue;
            if (candidate % 13 != 0) continue;
            if (candidate % 14 != 0) continue;
            if (candidate % 15 != 0) continue;
            if (candidate % 16 != 0) continue;
            if (candidate % 17 != 0) continue;
            if (candidate % 18 != 0) continue;
            if (candidate % 19 != 0) continue;
            //if (candidate % 20 != 0) continue;
            return candidate;
        } //
    } // SmallestMultiple()

    public static void main(String[] args) {
        long n = SmallestMultiple();
        System.out.println("answer is " + n);
    } // main()
} // class Problem005

