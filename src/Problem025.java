import java.math.BigInteger;
/*
ProjectEuler.net
Problem 25 - 1000-digit Fibonacci Number

The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

 */
public class Problem025 {

    public static void main(String[] args) {

        BigInteger fibonacci1 = BigInteger.ZERO;
        BigInteger fibonacci2 = BigInteger.ONE;
        BigInteger fibonacciSum = fibonacci1.add(fibonacci2);
        int fibonacciIndex = 2;

        while (fibonacciSum.toString().length() < 1_000) {
            fibonacci1 = fibonacci2;
            fibonacci2 = fibonacciSum;
            fibonacciSum = fibonacci1.add(fibonacci2);
            fibonacciIndex++;
        } // while

        System.out.println("answer is " + fibonacciIndex);

    } // main()

} // class Problem025
