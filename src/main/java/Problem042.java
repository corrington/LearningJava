import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
ProjectEuler.net
Problem 42 - Coded triangle numbers

The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

         1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values
we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number
then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words,
how many are triangle words?
 */
public class Problem042 {

    public String[] readWords() {

        String[] wordList = new String[0];

        String filename = "d:\\p042_words.txt";

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                // there should be only one line of words in the file
                String aRowOfWords = scanner.nextLine();
                // break the one long string containing multiple words
                // into an array of shorter strings containing one word in each element
                wordList = aRowOfWords.split("\",\"");

                // clean up the first and last words
                // strip off the double quote at the front
                wordList[0] = wordList[0].substring(1);

                // strip off the double quote at the end
                String lastWord = wordList[wordList.length-1];
                wordList[wordList.length-1] = lastWord.substring(0,lastWord.length() - 1);

            } // if

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("error: data file not found, " + filename);
        } // catch

        return wordList;

    } // readWords()

    int[] calcWordListValues(final String[] wordList) {
        if ((wordList == null) || (wordList.length == 0)) return null;

        final int numOfWords = wordList.length;
        int[] wordValues = new int[numOfWords];

        for (int i = 0; i < numOfWords; i++) {
            wordValues[i] = calcWordValue(wordList[i]);
        } // for i

        return wordValues;

    } // calcWordListValues()

    int calcWordValue(final String word) {
        if ((word == null) || (word.length() == 0)) return 0;
        char[] letters = word.toCharArray();

        int wordValue = 0;
        for (char letter : letters) {
            wordValue = wordValue + (letter - 'A' + 1);
        } // for letter
        return wordValue;

    } // calcWordValue()

    int getTriangleNumber(final int nth) {
        int result = (nth * (nth + 1)) / 2;
        return result;
    } // getTriangleNumber()

     ArrayList<Integer> buildTriangleNumberList(final int maxWordValue) {
        // build a list of triangle numbers that will be used later
        // since we don't know how many we will need, using an ArrayList
        // to collect the triangle numbers as we generate them
        var triangleNumbers = new ArrayList<Integer>();
        int triangleNumber = 0;
        for (int i = 1; triangleNumber <= maxWordValue; i++) {
            triangleNumber = getTriangleNumber(i);
            triangleNumbers.add(triangleNumber);
        } // while

        return triangleNumbers;
    } // buildTriangleNumberList()

    public static void main(String[] args) {

        var p42 = new Problem042();

        // read the list of words from a text file
        String[] wordList = p42.readWords();
        final int numOfWords = wordList.length;

        // calculate the word value for each word in the list
        int[] wordValues = p42.calcWordListValues(wordList);

        for (int i = 0; i < numOfWords; i++) {
            System.out.println(wordList[i] + " = " + wordValues[i]);
        } // for i

        // sort the list word values so we can easily find the max word value
        Arrays.sort(wordValues);
        int maxWordValue = wordValues[numOfWords - 1];

        // build a cache of triangle numbers...
        ArrayList<Integer> triangleNumbers = p42.buildTriangleNumberList(maxWordValue);

        // so we can use a binary search to determine if a word value is in the
        // cache of triangle numbers.
        int numOfTriangleWords = 0;
        for (var wordValue : wordValues) {
            if (Collections.binarySearch(triangleNumbers, wordValue) >= 0) {
                numOfTriangleWords++;
            } // if
        } // for

        System.out.println("answer is " + numOfTriangleWords);

    } // main()

} // class Problem042
