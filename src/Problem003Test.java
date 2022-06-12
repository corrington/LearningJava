import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem003Test {

    @Test
    void testGetLargestPrimeFactor() {
        assertEquals(Problem003.getLargestPrimeFactor(2), 2);
        assertEquals(Problem003.getLargestPrimeFactor(3), 3);
        assertEquals(Problem003.getLargestPrimeFactor(4), 2);
        assertEquals(Problem003.getLargestPrimeFactor(5), 5);
        assertEquals(Problem003.getLargestPrimeFactor(6), 3);
        assertEquals(Problem003.getLargestPrimeFactor(7), 7);
        assertEquals(Problem003.getLargestPrimeFactor(8), 2);
        assertEquals(Problem003.getLargestPrimeFactor(9), 3);
        assertEquals(Problem003.getLargestPrimeFactor(10), 5);
        assertEquals(Problem003.getLargestPrimeFactor(11), 11);
        assertEquals(Problem003.getLargestPrimeFactor(600_851_475_143L), 6857);
    } // testGetLargestPrimeFactor()
} // class Problem003Test