import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem010Test {

    @Test
    void getSumOfPrimes() {
        Problem010 p = new Problem010();
        assertEquals(2L, p.getSumOfPrimes(2));
        assertEquals(2L, p.getSumOfPrimes(3));
        assertEquals(5L, p.getSumOfPrimes(4));
        assertEquals(5L, p.getSumOfPrimes(5));
        assertEquals(10L, p.getSumOfPrimes(6));
        assertEquals(10L, p.getSumOfPrimes(7));
        assertEquals(17L, p.getSumOfPrimes(8));
        assertEquals(17L, p.getSumOfPrimes(9));
        assertEquals(17L, p.getSumOfPrimes(10));
        assertEquals(17L, p.getSumOfPrimes(11));
        assertEquals(28L, p.getSumOfPrimes(12));
        assertEquals(28L, p.getSumOfPrimes(13));
        assertEquals(41L, p.getSumOfPrimes(14));
        assertEquals(41L, p.getSumOfPrimes(15));
        assertEquals(41L, p.getSumOfPrimes(16));
        assertEquals(41L, p.getSumOfPrimes(17));
        assertEquals(58L, p.getSumOfPrimes(18));
        assertEquals(58L, p.getSumOfPrimes(19));
        assertEquals(77L, p.getSumOfPrimes(20));
        assertEquals(142_913_828_922L, p.getSumOfPrimes(2_000_000));
    } // getSumOfPrimes()
} // class Problem010Test