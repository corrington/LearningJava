/*
ProjectEuler.net
Problem 15 - Lattice paths
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.
How many such routes are there through a 20×20 grid?
 */


import java.util.HashMap;

public class Problem015 {


    static HashMap<KeyPair, Long> lookupTable = new HashMap<>();

    public static long countRoutes1(long m, long n) {
        if ((n == 0) || (m == 0)) {
            return 1;
        }

        return countRoutes1(m, n - 1) + countRoutes1(m - 1, n);

    } // countRoutes1()

    public static long countRoutes2(int m, int n) {
        if ((m == 0) || (n == 0)) {
            return 1;
        }

        // If we've seen this pair of m's and n's before,
        // simply report the number of routes we previously calculated.
        KeyPair kp = new KeyPair(m, n);

        if (lookupTable.containsKey(kp)) {
            Long previousRoutes = lookupTable.get(kp);
            //System.out.println("found key pair [" + m + ","+ n + "] = " + previousRoutes);  // DEBUG
            return previousRoutes;
        }

        long totalRoutes = countRoutes2(m, n - 1) + countRoutes2(m - 1, n);

        if (!lookupTable.containsKey(kp)) {
            lookupTable.put(kp, totalRoutes);
            //System.out.println("adding [" + m + "," + n + "] (" + kp.hashCode() + ") = " + totalRoutes);  // DEBUG
        }
        return totalRoutes;

    } // countRoutes2()

    public static void main(String[] args) {

        int m = 18, n = 18;

        System.out.println("Version 1");
        var sw1 = new Stopwatch();
        long routes = countRoutes1(m, n);
        System.out.println("elapsed time is " + sw1.elapsedTime());
        System.out.println("number of routes is " + routes);

        System.out.println();
        System.out.println("Version 2");
        var sw2 = new Stopwatch();
        routes = countRoutes2(m, n);
        System.out.println("elapsed time is " + sw2.elapsedTime());
        System.out.println("number of routes is " + routes);

    } // main()
} // class Problem015

/*
We have a key with two parts: m and n.  This class was made to fuse the two parts together, so I could use
the standard Java HashMap for quick lookups in the second version of the solution.
 */
class KeyPair {
    private int m;
    private int n;

    public KeyPair(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public long getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public long getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setMN(int m, int n) {
        this.m = m;
        this.n = n;
    }

    /*
        Note: I overrode the equals function because the key [3,2] should produce the same value as the key [2,3]
     */
    @Override
    public boolean equals(final Object o) {
        if (o == null)
            return false;

        // If the object is compared with itself...
        if (o == this)
            return true;

        /* Check if o is an instance of KeyPair or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof KeyPair kp))
            return false;

        if ((this.m == kp.m) && (this.n == kp.n))   // [3,2] equals [3,2] AND [2,3] equals [2,3]
            return true;
        // [3,2] equals [2,3] AND [2,3] equals [3,2]
        return (this.m == kp.n) && (this.n == kp.m);

    } // equals()

    /*
    Note: Again, I overrode the hashCode function because the key [3,2] should produce the same value as the key [2,3].
    Equally important it should NOT produce the same value for other keys, like [6,1] and [1.6].
 */
    @Override
    public int hashCode() {
        int min = Math.min(this.m, this.n);
        int max = Math.max(this.m, this.n);
        String s = "[" + min + "," + max + "]";
        return  s.hashCode();
    } // hashCode()

    @Override
    public String toString() {
        String s = "[" + this.m + "," + this.n + "](" + hashCode() + ")";
        return s;
    } // toString()

}