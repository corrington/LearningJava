import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem004Test {

    @Test
    void reverse() {
        Problem004 p = new Problem004();

        assertEquals(p.reverse(7), 7);
        assertEquals(p.reverse(11), 11);
        assertEquals(p.reverse(21), 12);
        assertEquals(p.reverse(211), 112);
        assertEquals(p.reverse(123), 321);
        assertEquals(p.reverse(1234), 4321);
        assertEquals(p.reverse(12345), 54321);
        assertEquals(p.reverse(11011), 11011);
        assertEquals(p.reverse(10001), 10001);
    } // reverse()

    @Test
    void isPalindrome() {
        Problem004 p = new Problem004();

        assertTrue(p.isPalindrome(11));
        assertTrue(p.isPalindrome(111));
        assertTrue(p.isPalindrome(1111));
        assertTrue(p.isPalindrome(10001));
        assertTrue(p.isPalindrome(10101));

        assertFalse(p.isPalindrome(10));
        assertFalse(p.isPalindrome(100));
        assertFalse(p.isPalindrome(1101));
        assertFalse(p.isPalindrome(11001));
        assertFalse(p.isPalindrome(11001));
    } // isPalindrome()

    @Test
    void largestPalindromeOfThreeDigitNumbers() {
        Problem004 p = new Problem004();
        assertEquals(p.largestPalindromeOfThreeDigitNumbers(), 906609);
    } // largestPalindromeOfThreeDigitNumbers()
} // class Problem004Test