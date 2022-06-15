import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyPairTest {

    @Test
    void getM() {
        KeyPair kp = new KeyPair(5, 6);
        assertEquals(5, kp.getM());
    }

    @Test
    void setM() {
        KeyPair kp = new KeyPair(5, 6);
        kp.setM(7);
        assertEquals(7, kp.getM());
    }

    @Test
    void getN() {
        KeyPair kp = new KeyPair(5, 6);
        assertEquals(6, kp.getN());
    }

    @Test
    void setN() {
        KeyPair kp = new KeyPair(5, 6);
        kp.setN(7);
        assertEquals(7, kp.getN());
    }

    @Test
    void setMN() {
        KeyPair kp = new KeyPair(5, 6);
        kp.setMN(7, 8);
        assertEquals(7, kp.getM());
        assertEquals(8, kp.getN());
    }

    @Test
    void testEquals() {
        KeyPair kp1 = new KeyPair(5, 6);
        KeyPair kp2 = new KeyPair(6, 5);
        assertEquals( kp1, kp1);
        assertEquals( kp1, kp2);
        assertEquals( kp2, kp1);

        KeyPair kp3 = new KeyPair(1, 2);
        KeyPair kp4 = new KeyPair(3, 4);
        assertNotEquals(kp3, kp4);
        assertNotEquals(kp4, kp3);

        KeyPair kp5 = new KeyPair(1, 7);
        KeyPair kp6 = new KeyPair(3, 1);
        assertNotEquals(kp5, kp6);
        assertNotEquals(kp6, kp5);

        KeyPair kp7 = new KeyPair(7, 1);
        KeyPair kp8 = new KeyPair(1, 3);
        assertNotEquals(kp7, kp8);
        assertNotEquals(kp8, kp7);

        KeyPair kp10 = new KeyPair(9, 3);
        KeyPair kp11 = new KeyPair(9, 3);
        assertEquals( kp10, kp11);
        assertEquals( kp11, kp10);

    } // testEquals()

} // class KeyPairTest
