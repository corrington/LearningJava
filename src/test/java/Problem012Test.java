import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem012Test {

    @Test
    void getHighlyDivisibleTriangularNumber() {
        Problem012 p = new Problem012();

        //assertEquals(1L, p.getHighlyDivisibleTriangularNumber(1));
        assertEquals(3L, p.getHighlyDivisibleTriangularNumber(2));
        assertEquals(6L, p.getHighlyDivisibleTriangularNumber(4));
        assertEquals(28L, p.getHighlyDivisibleTriangularNumber(6));
        assertEquals(76576500L, p.getHighlyDivisibleTriangularNumber(501));
    } // getHighlyDivisibleTriangularNumber()
} // class Problem012Test