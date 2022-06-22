import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/*
ProjectEuler.net
Problem 22 - Names scores
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value
by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the
938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */
public class Problem022 {

    public String[] readNames() {
        String[] names = new String[0];

            String filename = "d:\\p022_names.txt";

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                // there should be only one line of names in the file
                String aRowOfNames = scanner.nextLine();
                // break the one long string containing multiple names
                // into an array of shorter strings containing one name in each element
                names = aRowOfNames.split("\",\"");

                // clean up the first and last names
                names[0] = names[0].substring(1); // strip off the double quote at the front
                String lastName = names[names.length-1];
                names[names.length-1] = lastName.substring(0,lastName.length() - 1); // strip off the double quote at the end

            } // if

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("error: data file not found, " + filename);
        } // catch

        return names;

    } // readNames()

    // determine the score of an individual name
    public int scoreName(String name) {
        int score = 0;

        var nameChars = name.toCharArray();

        for (char ch : nameChars) {
            score += (int) ch - (int) 'A' + 1;          // assumes only capital letters
        } // for

        return score;
    } // scoreName()

    // score the entire list of names
    public long scoreNames(String[] names) {
        long score = 0;

        Arrays.sort(names);

        for (int i = 0; i < names.length; i++) {
            score += ((long)i + 1L) * scoreName(names[i]) ;
        } // for

        return score;

    } // scoreNames()

    public static void main(String[] args) {
        Problem022 p = new Problem022();
        String[] names = p.readNames();
        long score = p.scoreNames(names);
        System.out.println("answer is " + score);
    } // main()
} // class Problem022
