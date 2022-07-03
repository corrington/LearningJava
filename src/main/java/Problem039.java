/*
ProjectEuler.net
Problem 39 - Integer right triangles
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are
exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

Note: I am not a math wonk, therefore this is an ugly brute-forced approach. I am not proud.
 */
public class Problem039 {

    static boolean isRightAngleTriangle(final int a, final int b, final int c) {
        boolean answer = (c*c == a*a + b*b);
        return answer;
    } // isRightAngleTriangle()


    public static void main(String[] args) {

        final int maxP = 1_000;
        int[] ps = new int[maxP];


        for (int p = 4; p < maxP; p++) {

            int solutions = 0;

            for (int c = 3; c <= (p / 2); c++) {

                for (int b = 1; b < c; b++) {

                    for (int a = 1; a < c; a++) {

                        if (isRightAngleTriangle(a, b, c) && (p == a + b + c)) {
                            solutions++;
                        }

                    } // for a

                } // for b

            } // for c

            ps[p] = solutions / 2;

        } // for p

        int maxSolutions = 0;
        int pWithMaxSolutions = 0;
        for (int i = 4; i < maxP; i++) {
            if (ps[i] > maxSolutions) {
                maxSolutions = ps[i];
                pWithMaxSolutions = i;
            }
        }  // for i

        System.out.println("answer is " + pWithMaxSolutions);

    } // main()

} // class Problem039
