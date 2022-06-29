import org.apache.commons.math3.fraction.Fraction;

import java.util.ArrayList;

/*
ProjectEuler.net
Problem 33 - Digit cancelling fractions
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly
believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits
in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem033 {
    // we have a curious fraction candidate if a digit in the numerator equals a digit in the denominator
    static boolean isCuriousFractionCandidate(final int n, final int d) {
        int n1 = n / 10;
        int n2 = n % 10;
        int d1 = d / 10;
        int d2 = d % 10;

        // exclude trivial examples
        if ((n2 == 0) && (d2 == 0)) return false;

        if (n1 == d1) return true;
        if (n1 == d2) return true;
        if (n2 == d1) return true;
        return n2 == d2;

    } //  isCuriousFraction()

    static Fraction incorreclySimplify(final int n, final int d) {

        // break the numerator and denominator into their respective digits
        int n1 = n / 10;
        int n2 = n % 10;
        int d1 = d / 10;
        int d2 = d % 10;

        int newN, newD;

        // determine which digits from the numerator and denominator we're going to use
        // for example, if 49/98, toss the 9s and keep the 4/8
        if (n1 == d1) {
            newN = n2;
            newD = d2;
        } else if (n1 == d2) {
            newN = n2;
            newD = d1;
        } else if (n2 == d1) {
            newN = n1;
            newD = d2;
        } else {
            newN = n1;
            newD = d1;
        }

        // if the denominator is zero, we can't divide by zero.
        // for example 28/80, tossing the 8s, leaves us with 2/0, which is illegal
        // the problem is looking for fractions less than one,
        // so let's pass back a fraction equal to one, which will fail subsequent tests
        if (newD == 0) {
            newN = 1;
            newD = 1;
        }

        // Now that we have the 4/8, turn it into a fraction
        var frac = new Fraction(newN, newD);
        return frac;
    } // incorreclySimplify()

    // can we simplify incorrectly and still get the correct answer?
    static boolean canSimplifyIncorrectly(final int n, final int d) {
        var correctlySimplified = new Fraction(n, d); // when a fraction is created it is always reduced to lowest terms.
        var incorrectlySimplified = incorreclySimplify(n, d);
        return correctlySimplified.equals(incorrectlySimplified);
    } // canSimplifyIncorrectly()


    static ArrayList<Fraction> getListOfCorrectlySimplifiedCuriousFractions() {
        var listOfCuriousFractions = new ArrayList<Fraction>();
        // let's look at all the two-digit fractions that are less than 1...
        for (int n = 11; n < 98; n++) {
            for (int d = (n + 1); d < 99; d++) {
                if (isCuriousFractionCandidate(n, d)) {
                    //System.out.println(n + " / " + d);  // DEBUG
                    if (canSimplifyIncorrectly(n, d)) {
                        // System.out.println("*** " + n + " / " + d);  // DEBUG
                        // if we can simplify it incorrectly but still get the correct answer, save it
                        listOfCuriousFractions.add(new Fraction(n, d));
                    } // if
                } // if
            } // for d
        }  // for n
        return listOfCuriousFractions;
    } // getListOfCorrectlySimplifiedCuriousFractions()

    // multiply the list of correctly simplified curious fractions together and return just the denominator.
    static int getDenominatorOfProduct(ArrayList<Fraction> list) {
        if (list.size() == 0) throw new IllegalStateException("list cannot be empty");
        Fraction prodFrac = new Fraction(1, 1);
        for (Fraction curiousFrac : list) {
            prodFrac = prodFrac.multiply(curiousFrac);
        } // for
        return prodFrac.getDenominator();
    } // getDenominatorOfProduct()


    public static void main(String[] args) {
        var list= getListOfCorrectlySimplifiedCuriousFractions();
        System.out.println("answer is " + getDenominatorOfProduct(list));
    } // main()

} // class Problem033

