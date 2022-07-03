import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem043Test {

    @Test
    void isHighlyDivisiblePandigital() {
        var p = new Problem043();
    } // isHighlyDivisiblePandigital()

    @Test
    void digitsToNumber1() {   // long digitsToNumber(final int[] digits)
        var p = new Problem043();

        int[] digits1 = {1};
        assertEquals(1L, p.digitsToNumber(digits1));

        int[] digits2 = {1,2};
        assertEquals(12L, p.digitsToNumber(digits2));

        int[] digits3 = {1,2,3};
        assertEquals(123L, p.digitsToNumber(digits3));

        int[] digits4 = {1,2,3,4};
        assertEquals(1234L, p.digitsToNumber(digits4));

        int[] digitsMax = {9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,7};
        assertEquals(Long.MAX_VALUE, p.digitsToNumber(digitsMax));
    } // digitsToNumber()

    @Test
    void DigitsToNumber2() { // int digitsToNumber(final int[] digits, final int starting, final int ending)
        var p = new Problem043();

        int[] digits = {9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,7};
        assertEquals(9, p.digitsToNumber(digits,0,0));
        assertEquals(92, p.digitsToNumber(digits,0,1));
        assertEquals(922, p.digitsToNumber(digits,0,2));
        assertEquals(337, p.digitsToNumber(digits,3,5));
        assertEquals(36854, p.digitsToNumber(digits, 7,12));
        assertEquals(807, p.digitsToNumber(digits, 16,18));
        assertEquals(7, p.digitsToNumber(digits, 17,18));
        assertEquals(7, p.digitsToNumber(digits, 18,18));
    } // testDigitsToNumber()
} // class Problem043Test