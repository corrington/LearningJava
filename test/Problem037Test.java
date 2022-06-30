import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem037Test {

    @Test
    void isTruncatable() {

        var p = new Problem037();

        assertFalse(p.isTruncatable(7));
        assertFalse(p.isTruncatable(10));
        assertFalse(p.isTruncatable(137));
        assertFalse(p.isTruncatable(197));
        assertFalse(p.isTruncatable(227));

        assertTrue(p.isTruncatable(23));
        assertTrue(p.isTruncatable(37));
        assertTrue(p.isTruncatable(53));
        assertTrue(p.isTruncatable(73));
        assertTrue(p.isTruncatable(313));
        assertTrue(p.isTruncatable(317));
        assertTrue(p.isTruncatable(373));
        assertTrue(p.isTruncatable(797));
        assertTrue(p.isTruncatable(3137));
        assertTrue(p.isTruncatable(3797));
        assertTrue(p.isTruncatable(739397));

    } // isTruncatable()

    @Test
    void powsOfTen() {
        var p = new Problem037();

        assertEquals(1, p.powsOfTen(0));
        assertEquals(10, p.powsOfTen(1));
        assertEquals(100, p.powsOfTen(2));
        assertEquals(1_000, p.powsOfTen(3));
        assertEquals(10_000, p.powsOfTen(4));
        assertEquals(100_000, p.powsOfTen(5));
        assertEquals(1_000_000, p.powsOfTen(6));
        assertEquals(10_000_000, p.powsOfTen(7));
        assertEquals(100_000_000, p.powsOfTen(8));
        assertEquals(1_000_000_000, p.powsOfTen(9));

        Exception exception1 = assertThrows(IndexOutOfBoundsException.class, () -> p.powsOfTen(-1));
        String expectedMessage1 = "unsupported exponent -1";
        String actualMessage1 = exception1.getMessage();
        assertTrue(actualMessage1.contains(expectedMessage1));

        Exception exception2 = assertThrows(IndexOutOfBoundsException.class, () -> p.powsOfTen(10));
        String expectedMessage2 = "unsupported exponent 10";
        String actualMessage2 = exception2.getMessage();
        assertTrue(actualMessage2.contains(expectedMessage2));

    } // powOfTen()

} // class Problem037Test