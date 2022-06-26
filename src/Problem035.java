/*
ProjectEuler.net
Problem 35 -  Circular primes

The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 */

import static org.apache.commons.math3.primes.Primes.isPrime;

public class Problem035 {

    public static void main(String[] args) {
        var p = new Problem035();
        int numOfCircularPrimes = 1;
        for (int n = 3; n < 1_000_000; n += 2) {
            if (p.isCircularPrime(n)) {
                numOfCircularPrimes++;
            } // if
        } // for n
        System.out.println("number of circular primes is " + numOfCircularPrimes);

    } // main()

    // convert an int into and array of digits
    int[] getListOfDigits(final int n) {
        int numOfDigits = getNumOfDigits(n);
        int[] listOfDigits = new int[numOfDigits];

        // populate the array of digits from right to left
        int working = n;
        for (int i = (numOfDigits - 1); i >= 0; --i) {
            listOfDigits[i] = working % 10;
            working /= 10;
        } // for
        return listOfDigits;
    } // getListOfDigits()

    // convert an array of digits into an int
    int valueOf(int[] listOfDigits) {
        int n = 0;
        for (int digit : listOfDigits) {
            n = (n * 10) + digit;
        } // for i
        return n;
    } // valueOf()

    // rotate an array of digits
    int[] rotateListOfDigits(final int[] listOfDigits) {
        if (listOfDigits.length == 1)
            return listOfDigits;

        // a new array to hold the new rotated list of digits
        int[] newListOfDigits = new int[listOfDigits.length];

        // save the left most digit
        int savedDigit = listOfDigits[0];

        // copy the others digits into their new positions
        for (int i = 0; i < (listOfDigits.length - 1); i++) {
            newListOfDigits[i] = listOfDigits[i + 1];
        } // for i

        // append the previous "left most digit" to the end
        newListOfDigits[listOfDigits.length - 1] = savedDigit;

        return newListOfDigits;
    } // rotateListOfDigits()

    // returns an array of integers that contains every possible
    // combination of rotations of its digits (e.g., 123, 231, 321)
    int[] getListOfRotations(final int n) {

        int numOfDigits = getNumOfDigits(n);
        int[] listOfRotations = new int[numOfDigits];

        listOfRotations[0] = n;  // start the list with the original number

        if (numOfDigits == 1) return listOfRotations;

        int[] listOfDigits = getListOfDigits(n);
        for (int i = 1; i < numOfDigits; i++) {
            listOfDigits = rotateListOfDigits(listOfDigits);
            listOfRotations[i] = valueOf(listOfDigits);
        } // for i

        return listOfRotations;

    } // getListOfRotations()

    // no prime can be circular if it contains any digits in [0,2,4,5,6,8]
    boolean containsSpecialDigits(final int n) {
        int[] digits = getListOfDigits(n);
        for (int digit : digits) {
            if (((digit % 2) == 0) || ((digit % 5) == 0)) return true;
        } // for i
        return false;
    } // containsSpecialDigits()

    boolean isCircularPrime(final int n) {
        if (isPrime(n) && (n < 10)) return true;
        if (containsSpecialDigits(n)) return false;

        int[] listOfRotations = getListOfRotations(n);
        for (int listOfRotation : listOfRotations) {
            if (!isPrime(listOfRotation)) return false;
        } // for i

        return true;
    } // isCircularPrime()

    // reports the number of digits in a number (e.g., 7352 has 4 digits)
    // Taken from https://www.baeldung.com/java-number-of-digits-in-int
    int getNumOfDigits(final int number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    } // getNumOfDigits()

} // class Problem035