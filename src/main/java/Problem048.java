/*
ProjectEuler.net
Problem 48 - Self powers
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10,405,071,317.
Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
import java.math.BigDecimal;
public class Problem048 {

    public static void main(String[] args) {

        final int maxN = 1_000;

        BigDecimal bigSum = BigDecimal.ZERO;

        for (int n = 1; n <= maxN; n++) {
            BigDecimal bigN = new BigDecimal(n);
            bigSum = bigSum.add(bigN.pow(n));
        } // for n

        String bigString = bigSum.toString();
        String lastTenDigits = bigString.substring(bigString.length() - 10);

        System.out.println("answer is " + lastTenDigits);

    } // main()

} // class Problem048
