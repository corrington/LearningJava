package com.corrington;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
A programming problem taken from a Stanford University CS class
to help me practice creating recursive methods.
https://web.stanford.edu/class/archive/cs/cs106b/cs106b.1228/assignments/3-recursion/balanced

Determines if the sequence of operations is balanced.
(){([])(())} is balanced
(([])        The line is missing a closing parenthesis.
)(           The closing parenthesis comes before the opening parenthesis.
{(})         The parentheses and braces are improperly nested.
 */
public class BalancedOperators {

    private static String removeOperator(String str, String op) {
        StringBuilder sb = new StringBuilder(str);
        int startingIndex = str.indexOf(op);
        sb.delete(startingIndex, startingIndex + 2);
        String substring = sb.toString();
        return substring;
    } // removeOperator()


    public static boolean operatorsAreMatched(String str) {
        if (str.isEmpty()) return true;

        if (str.contains("()")) {
            String substr = removeOperator(str, "()");
            return operatorsAreMatched(substr);
        } else if (str.contains("{}")) {
            String substr = removeOperator(str, "{}");
            return operatorsAreMatched(substr);
        } else if (str.contains("[]")) {
            String substr = removeOperator(str, "[]");
            return operatorsAreMatched(substr);
        }
        return false;
    } // operatorsAreMatched()

    public static String operatorsFrom1(String str) {
        if (str.isEmpty()) return ""; // base case

        // get a copy of the first character
        char ch = str.charAt(0);
        // If it's one we care about...
        if ((ch == '(') || (ch == '[') || (ch == '{') || (ch == '}') || (ch == ']') || (ch == ')')) {
            // ...keep it and check the rest of the string
            return ch + operatorsFrom1(str.substring(1));

        } else {
            // since it's not a char we care about, save nothing "" and
            // check the rest of the characters in the string
            return "" + operatorsFrom1(str.substring(1));
        } //if

    } // operatorsFrom1()


    // I didn't like the obscene if statement in the first version of this method.
    // So I used a regular expression to see if I could simplify the code.
    // Not sure that I did, but it's interesting.  It's probably more efficient because it jumps
    // from one matching char to the next, rather than make a call for every single char in the string.
    public static String operatorsFrom2(String str) {
        if (str.isEmpty()) return ""; // base case

        // use a regular expression pattern to see if there are operator brackets in the string
        Matcher matcher = Pattern.compile("[{(\\[\\])}]").matcher(str);
        if (matcher.find()) {
            // get the position of the first matching operator bracket
            int startingIndex = matcher.start();
            // get a copy of the first operator bracket, then check the rest of the string
            return str.charAt(startingIndex) + operatorsFrom2(str.substring(startingIndex + 1));
        } else {
            // Since there were no operator brackets, return nothing
            return "";
        } // if

    } // operatorsFrom2()


    public static void main(String[] args) {

        System.out.println( operatorsFrom2("int main() { int x = 2 * (vec[2] + 3); x = (1 + random()); }"));
        System.out.println( operatorsFrom2("( ( [ a ] )"));
        System.out.println( operatorsFrom2("3 ) ( "));
        System.out.println( operatorsFrom2("{ ( x } y ) "));
        System.out.println("--------------------------");
        System.out.println( operatorsAreMatched("(){([])(())}"));
        System.out.println( operatorsAreMatched("(([])"));
        System.out.println( operatorsAreMatched(")("));
        System.out.println( operatorsAreMatched("{(})"));

    }  // main()

} // class BalancedOperators