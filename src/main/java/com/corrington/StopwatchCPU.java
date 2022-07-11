/******************************************************************************
 *  Compilation:  javac StopwatchCPU.java
 *  Execution:    none
 *  Dependencies: none
 *
 *  A version of Stopwatch.java that measures CPU time on a single
 *  core or processor (instead of wall clock time).
 *
 ******************************************************************************/
package com.corrington;

import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

/**
 *  The {@code StopwatchCPU} data type is for measuring
 *  the CPU time used during a programming task.
 *
 *  See {@link Stopwatch} for a version that measures wall-clock time
 *  (the real time that elapses).
 *
 *  @author Josh Hug
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class StopwatchCPU {
    private static final double NANOSECONDS_PER_SECOND = 1000000000;

    private final ThreadMXBean threadTimer;
    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public StopwatchCPU() {
        this.threadTimer = ManagementFactory.getThreadMXBean();
        this.start = this.threadTimer.getCurrentThreadCpuTime();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = this.threadTimer.getCurrentThreadCpuTime();
        return (now - this.start) / NANOSECONDS_PER_SECOND;
    }

    /**
     * Returns a String of the elapsed CPU time (in seconds) since the stopwatch was created.
     * @return a String of the elapsed CPU time (in seconds) since the stopwatch was created
     */
    @Override
    public String toString() {
        return "" + elapsedTime();
    } // toString()


} // class StopwatchCPU
