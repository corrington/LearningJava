import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem003Test {

    @Test
    void testGetLargestPrimeFactor() {
        Problem003 p = new Problem003();
        assertEquals(p.getLargestPrimeFactor(2), 2);
        assertEquals(p.getLargestPrimeFactor(3), 3);
        assertEquals(p.getLargestPrimeFactor(4), 2);
        assertEquals(p.getLargestPrimeFactor(5), 5);
        assertEquals(p.getLargestPrimeFactor(6), 3);
        assertEquals(p.getLargestPrimeFactor(7), 7);
        assertEquals(p.getLargestPrimeFactor(8), 2);
        assertEquals(p.getLargestPrimeFactor(9), 3);
        assertEquals(p.getLargestPrimeFactor(10), 5);
        assertEquals(p.getLargestPrimeFactor(11), 11);
        assertEquals(p.getLargestPrimeFactor(600_851_475_143L), 6857);
    } // testGetLargestPrimeFactor()
} // class Problem003Test