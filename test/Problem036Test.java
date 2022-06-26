import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem036Test {

    @Test
    void isPalindrome() {
        var p = new Problem036();
        // test decimal numbers (base 10)
        assertTrue(p.isPalindrome(0,10));
        assertTrue(p.isPalindrome(1,10));
        assertTrue(p.isPalindrome(2,10));
        assertTrue(p.isPalindrome(11,10));
        assertTrue(p.isPalindrome(22,10));
        assertTrue(p.isPalindrome(111,10));
        assertTrue(p.isPalindrome(303,10));
        assertTrue(p.isPalindrome(2112,10));
        assertTrue(p.isPalindrome(2002,10));

        assertFalse(p.isPalindrome(123,10));
        assertFalse(p.isPalindrome(103,10));
        assertFalse(p.isPalindrome(310,10));
        assertFalse(p.isPalindrome(304,10));

        // test binary numbers (base 2)
        assertTrue(p.isPalindrome(0b0,2));
        assertTrue(p.isPalindrome(0b1,2));
        assertTrue(p.isPalindrome(0b11,2));
        assertTrue(p.isPalindrome(0b101,2));
        assertTrue(p.isPalindrome(0b1001,2));
        assertTrue(p.isPalindrome(0b10101,2));
        assertTrue(p.isPalindrome(0b11111,2));

        assertFalse(p.isPalindrome(0b10,2));
        assertFalse(p.isPalindrome(0b100,2));
        assertFalse(p.isPalindrome(0b110,2));
        assertFalse(p.isPalindrome(0b111011,2));
    } // isPalindrome()

    @Test
    void reverseNumber() {
        var p = new Problem036();
        // test decimal numbers (base 10)
        assertEquals(0, p.reverseNumber(0, 10));
        assertEquals(1, p.reverseNumber(1, 10));
        assertEquals(1, p.reverseNumber(10, 10));
        assertEquals(1, p.reverseNumber(100, 10));
        assertEquals(1, p.reverseNumber(1000, 10));
        assertEquals(21, p.reverseNumber(12, 10));
        assertEquals(321, p.reverseNumber(123, 10));
        assertEquals(1001, p.reverseNumber(1001, 10));

        // test binary numbers (base 2)
        assertEquals( 0b1, p.reverseNumber(0b1, 2));
        assertEquals( 0b1, p.reverseNumber(0b10, 2));
        assertEquals( 0b1, p.reverseNumber(0b100, 2));
        assertEquals( 0b11, p.reverseNumber(0b11, 2));
        assertEquals( 0b101, p.reverseNumber(0b101, 2));
        assertEquals( 0b101, p.reverseNumber(0b0101, 2));
        assertEquals( 0b10111, p.reverseNumber(0b11101, 2));
        assertEquals( 0b11101, p.reverseNumber(0b10111, 2));
    } // reverseNumber()

} // class Problem036Test