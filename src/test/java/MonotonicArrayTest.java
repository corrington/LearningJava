import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicArrayTest {

    @Test
    void isMonotonic1() {
        var obj = new MonotonicArray();

        assertTrue(obj.isMonotonic1(new int[] {1,2,2,3}));
        assertTrue(obj.isMonotonic1(new int[] {6,5,4,4}));
        assertFalse(obj.isMonotonic1(new int[] {1,3,2}));
        assertTrue(obj.isMonotonic1(new int[] {0}));
        assertTrue(obj.isMonotonic1(new int[] {1,2}));
        assertTrue(obj.isMonotonic1(new int[] {2,1}));
        assertTrue(obj.isMonotonic1(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        assertTrue(obj.isMonotonic1(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2}));
        assertTrue(obj.isMonotonic1(new int[] {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        assertTrue(obj.isMonotonic1(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0}));
        assertTrue(obj.isMonotonic1(new int[] {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        assertFalse(obj.isMonotonic1(new int[] {1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1}));
        assertFalse(obj.isMonotonic1(new int[] {1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1}));

    } // isMonotonic()


    @Test
    void isMonotonic2() {
        var obj = new MonotonicArray();

        assertTrue(obj.isMonotonic2(new int[] {1,2,2,3}));
        assertTrue(obj.isMonotonic2(new int[] {6,5,4,4}));
        assertFalse(obj.isMonotonic2(new int[] {1,3,2}));
        assertTrue(obj.isMonotonic2(new int[] {0}));
        assertTrue(obj.isMonotonic2(new int[] {1,2}));
        assertTrue(obj.isMonotonic2(new int[] {2,1}));
        assertTrue(obj.isMonotonic2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        assertTrue(obj.isMonotonic2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2}));
        assertTrue(obj.isMonotonic2(new int[] {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        assertTrue(obj.isMonotonic2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0}));
        assertTrue(obj.isMonotonic2(new int[] {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        assertFalse(obj.isMonotonic2(new int[] {1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1}));
        assertFalse(obj.isMonotonic2(new int[] {1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1}));

    } // isMonotonic2()

} // class MonotonicArrayTest