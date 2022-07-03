import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem002Test {

    @Test
    void testSumOfEvenFibonacciTerms() {
        Problem002 p = new Problem002();
        assertEquals(p.sumOfEvenFibonacciTerms(200), 188);
        assertEquals(p.sumOfEvenFibonacciTerms(4_000_000), 4_613_732);
    } // testSumOfEvenFibonacciTerms()
} // Problem002Test