import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem034Test {

    @Test
    void factorialOfDigit() {
        var p = new Problem034();

        assertEquals(1, p.factorialOfDigit(0));
        assertEquals(1, p.factorialOfDigit(1));
        assertEquals(2, p.factorialOfDigit(2));
        assertEquals(6, p.factorialOfDigit(3));
        assertEquals(24, p.factorialOfDigit(4));
        assertEquals(120, p.factorialOfDigit(5));
        assertEquals(720, p.factorialOfDigit(6));
        assertEquals(5_040, p.factorialOfDigit(7));
        assertEquals(40_320, p.factorialOfDigit(8));
        assertEquals(362_880, p.factorialOfDigit(9));
    } // factorialOfDigit()

    @Test
    void toDigitArray() {
        var p = new Problem034();

        int[] expectedDigits1 = {1, 2, 3};
        int[] actualDigits1 = p.toDigitArray(123);
        assertArrayEquals(expectedDigits1, actualDigits1);

        int[] expectedDigits2 = {1, 2, 3, 4, 5, 6, 7};
        int[] actualDigits2 = p.toDigitArray(1234567);
        assertArrayEquals(expectedDigits2, actualDigits2);

    } // toDigitArray()

} //class  Problem034Test