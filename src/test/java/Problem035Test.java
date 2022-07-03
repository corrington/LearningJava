import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem035Test {

    @Test
    void getNumOfDigits() {
        var p = new Problem035();
        // MAX_INTEGER is 2,147,483,647, so we only need to test up to ten digits
        assertEquals(1, p.getNumOfDigits(1));
        assertEquals(2, p.getNumOfDigits(11));
        assertEquals(3, p.getNumOfDigits(111));
        assertEquals(4, p.getNumOfDigits(1111));
        assertEquals(5, p.getNumOfDigits(11111));
        assertEquals(6, p.getNumOfDigits(111111));
        assertEquals(7, p.getNumOfDigits(1111111));
        assertEquals(8, p.getNumOfDigits(11111111));
        assertEquals(9, p.getNumOfDigits(111111111));
        assertEquals(10, p.getNumOfDigits(1111111111));
    } // getNumOfDigits()

    @Test
    void isCircularPrime() {
        var p = new Problem035();

        assertTrue(p.isCircularPrime(2));
        assertTrue(p.isCircularPrime(3));
        assertTrue(p.isCircularPrime(7));
        assertTrue(p.isCircularPrime(11));
        assertTrue(p.isCircularPrime(31));
        assertTrue(p.isCircularPrime(197));
        assertTrue(p.isCircularPrime(1193));
        assertTrue(p.isCircularPrime(1931));

        assertFalse(p.isCircularPrime(1));
        assertFalse(p.isCircularPrime(67));
        assertFalse(p.isCircularPrime(83));
        assertFalse(p.isCircularPrime(211));
        assertFalse(p.isCircularPrime(691));
        assertFalse(p.isCircularPrime(1753));
        assertFalse(p.isCircularPrime(1951));

    } // isCircularPrime()

    @Test
    void getListOfDigits() {
        var p = new Problem035();

        int[] exp1 = {1};
        assertArrayEquals(exp1, p.getListOfDigits(1));

        int[] exp2 = {1,2};
        assertArrayEquals(exp2, p.getListOfDigits(12));

        int[] exp3 = {1,2,3};
        assertArrayEquals(exp3, p.getListOfDigits(123));

        int[] exp4 = {1,2,3,4};
        assertArrayEquals(exp4, p.getListOfDigits(1234));

        int[] exp5 = {2,1,4,7,4,8,3,6,4,7};
        assertArrayEquals(exp5, p.getListOfDigits(Integer.MAX_VALUE));

    } // getListOfDigits()

    @Test
    void valueOf() {
        var p = new Problem035();

        int[] input1 = {1};
        assertEquals(1, p.valueOf(input1));

        int[] input2 = {1,2};
        assertEquals(12, p.valueOf(input2));

        int[] input3 = {1,2,3};
        assertEquals(123, p.valueOf(input3));

        int[] input4 = {1,2,3,4};
        assertEquals(1234, p.valueOf(input4));

        int[] input5 = {2,1,4,7,4,8,3,6,4,7};
        assertEquals(Integer.MAX_VALUE, p.valueOf(input5));

    } // valueOf()

    @Test
    void rotateListOfDigits() {
        var p = new Problem035();

        int[] input1 = {1};
        int[] output1 = {1};
        assertArrayEquals(output1, p.rotateListOfDigits(input1));

        int[] input2 = {2,1};
        int[] output2 = {1,2};
        assertArrayEquals(output2, p.rotateListOfDigits(input2));

        int[] input3 = {2,1,4,7,4,8,3,6,4,7};
        int[] output3 = {1,4,7,4,8,3,6,4,7,2};
        assertArrayEquals(output3, p.rotateListOfDigits(input3));

    } // rotateListOfDigits()

    @Test
    void getListOfRotations() {
        var p = new Problem035();

        int[] exp1 = {1};
        assertArrayEquals(exp1,p.getListOfRotations(1));

        int[] exp2 = {12,21};
        assertArrayEquals(exp2,p.getListOfRotations(12));

        int[] exp3 = {123,231,312};
        assertArrayEquals(exp3,p.getListOfRotations(123));

        int[] exp4 = {1234,2341,3412,4123};
        assertArrayEquals(exp4,p.getListOfRotations(1234));

        int[] exp5 = {12345,23451,34512,45123,51234};
        assertArrayEquals(exp5,p.getListOfRotations(12345));

        int[] exp6 = {123456,234561,345612,456123,561234,612345};
        assertArrayEquals(exp6,p.getListOfRotations(123456));

    } // getListOfRotations()
} // class Problem035Test