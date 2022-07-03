import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem007Test {

    @Test
    void getNthPrime() {
        Problem007 p = new Problem007();
        assertEquals(p.getNthPrime(1), 2);
        assertEquals(p.getNthPrime(2), 3);
        assertEquals(p.getNthPrime(3), 5);
        assertEquals(p.getNthPrime(4), 7);
        assertEquals(p.getNthPrime(5), 11);
        assertEquals(p.getNthPrime(6), 13);
    } // get10001stPrime()
} // class Problem007Test