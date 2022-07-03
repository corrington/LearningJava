import java.io.File;
import java.io.FileNotFoundException;
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

Note: In my previous version, I brute forced it (just for fun).  In this version, I used the inverse function.
 */
public class Problem042b {

    // read and parse the words from a text file and stuff them into an array of strings
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

    int calcWordValue(final String word) {
        if ((word == null) || (word.length() == 0)) return 0;
        char[] letters = word.toCharArray();

        int wordValue = 0;
        for (char letter : letters) {
            wordValue = wordValue + (letter - 'A' + 1);
        } // for letter
        return wordValue;

    } // calcWordValue()

/*
  Knowing that the inverse function of n(n+1)/2 is (Sqrt(1+8n)-1)/2,
  one has only to check if the result is an integer
 */
    boolean isTriangleNumber(final int n) {
        double wordScore = (Math.sqrt(1 + (8.0 * (double)n)) - 1.0) / 2.0;
        return (wordScore == (double)Math.round(wordScore));
    } // isTriangleNumber()


    public static void main(String[] args) {
        var p42b = new Problem042b();

        int numOfTriangleWords = 0;

        // read the list of words from the text file
        String[] wordList = p42b.readWords();

        // for each word, calculate the word value
        // and determine if the word value is a triangle number
        for (var word : wordList) {
            int wordValue = p42b.calcWordValue(word);
            if (p42b.isTriangleNumber(wordValue)) {
                numOfTriangleWords++;
            } // if
        } // for word

        // report the number of words whose value was a triangle number
        System.out.println("answer is " + numOfTriangleWords);

    } // main()

} // class Problem042b
