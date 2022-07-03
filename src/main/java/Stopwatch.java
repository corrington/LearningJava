/******************************************************************************
 *  Compilation:  javac Stopwatch.java
 *  Execution:    java Stopwatch n
 *  Dependencies: none
 *
 *  A utility class to measure the running time (wall clock) of a program.
 *
 *  % java8 Stopwatch 100000000
 *  6.666667e+11  0.5820 seconds
 *  6.666667e+11  8.4530 seconds
 *
 ******************************************************************************/

/**
 *  The {@code Stopwatch} data type is for measuring
 *  the time that elapses between the start and end of a
 *  programming task (wall-clock time).
 *
 *  See {@link StopwatchCPU} for a version that measures CPU time.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */


public class Stopwatch {

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        this.start = System.currentTimeMillis();
    } // Stopwatch()


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - this.start) / 1000.0;
    } // elapsedTime()

    /**
     * Returns a String of the elapsed CPU time (in seconds) since the stopwatch was created.
     * @return a String of the elapsed CPU time (in seconds) since the stopwatch was created
     */
    @Override
    public String toString() {
        return "" + elapsedTime();
    } // toString()

} // class Stopwatch