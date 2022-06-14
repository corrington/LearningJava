public class Problem006 {

    public long getSumOfSquares(int n) {
        long sumOfSquares = 0;
        for (long i = 1; i <= n; i++) {
            sumOfSquares += (i * i);
        } // for i
        return sumOfSquares;
    } // getSumOfSquares()
    public long getSquareOfTheSum(int n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        } // for i
        long squareOfTheSum = sum * sum;
        return squareOfTheSum;
    } // getSquareOfTheSum()

    /*
    brute force method
     */
    public long getSumSquareDifference(int n) {
        long sumSquareDifference = getSquareOfTheSum(n) - getSumOfSquares(n);
        return sumSquareDifference;
    } // getSumSquareDifference()

    /*
    more efficient method
     */
    public long getSumSquareDifferenceOptomized(int n) {
        long sum = n * ( n + 1L) / 2L;
        long sum_sq = (2L * n  + 1L) * (n  + 1L) * n / 6L;
        long sumSquareDifference = (sum * sum) - sum_sq;
        return sumSquareDifference;
    } // getSumSquareDifference()

} // class SumSquareDifference
