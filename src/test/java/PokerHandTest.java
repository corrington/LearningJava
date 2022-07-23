import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandTest {

    @Test
    void testToString() {
    } // testToString()

    @Test
    void isFlush() {
        var hand1 = new PokerHand("5H 4H 6H 7H KH");
        assertTrue(hand1.isFlush());

        var hand2 = new PokerHand("5H 4H 6S 7H KH");
        assertFalse(hand2.isFlush());
    } // isFlush()

    @Test
    void isOnePair() {
        var hand1 = new PokerHand("5H 4H 5D 7H KH");
        assertTrue(hand1.isOnePair());

        var hand2 = new PokerHand("5H 4H 6S 7H KH");
        assertFalse(hand2.isOnePair());

        var hand3 = new PokerHand("5H 4H 5C 7H 5S");
        assertFalse(hand3.isOnePair());

        var hand4 = new PokerHand("5H 5D 5C 7H 5S");
        assertFalse(hand4.isOnePair());

        var hand5 = new PokerHand("5H QD 5C QH QS");
        assertFalse(hand5.isOnePair());

    } // isOnePair()


    @Test
    void isTwoPairs() {
        var hand1 = new PokerHand("5H 4H 5D 4S KH");
        assertTrue(hand1.isTwoPairs());

        var hand2 = new PokerHand("5H 5D 5S 5H KH");
        assertFalse(hand2.isTwoPairs());

    } // isTwoPairs()

    @Test
    void isThreeOfAKind() {
        var hand1 = new PokerHand("5H 4H 5D 7S 5C");
        assertTrue(hand1.isThreeOfAKind());

        var hand2 = new PokerHand("5H 5D 5S 5H KH");
        assertFalse(hand2.isThreeOfAKind());

        var hand3 = new PokerHand("5H 5D 5S 2H 2C");
        assertFalse(hand3.isThreeOfAKind());

    } // isThreeOfAKind()

    @Test
    void isStraight() {
        var hand1 = new PokerHand("2H 3H 4D 5S 6C");
        assertTrue(hand1.isStraight());

        var hand2 = new PokerHand("2H 3D 5S 6H 7H");
        assertFalse(hand2.isStraight());

        var hand3 = new PokerHand("AH KD QS JH 2C");
        assertFalse(hand3.isStraight());

        // straight flushes return true
        var hand4 = new PokerHand("2H 3H 4H 5H 6H");
        assertTrue(hand4.isStraight());

        // royal flushes return true
        var hand5 = new PokerHand("JH TH QH KH AH");
        assertTrue(hand5.isStraight());


    } // isStraight()

        @Test
    void isFourOfAKind() {
        var hand1 = new PokerHand("5H 4H 5D 5S 5C");
        assertTrue(hand1.isFourOfAKind());

        var hand2 = new PokerHand("5H 5D 5S 7H KH");
        assertFalse(hand2.isFourOfAKind());
    } // isFourOfAKind()

    @Test
    void isFullHouse() {
        var hand1 = new PokerHand("5H 4H 5D 5S 4C");
        assertTrue(hand1.isFullHouse());

        var hand2 = new PokerHand("5H 5D 5S 7H KH");
        assertFalse(hand2.isFullHouse());

        var hand3 = new PokerHand("5H 5D 9S 7H KH");
        assertFalse(hand3.isFullHouse());

    } // isFullHouse()

    @Test
    void isStraightFlush() {
        var hand1 = new PokerHand("2H 3H 4H 5H 6H");
        assertTrue(hand1.isStraightFlush());

        var hand2 = new PokerHand("2H 3H 4H 5H 6S");
        assertFalse(hand2.isStraightFlush());

        var hand3 = new PokerHand("AH KH QH JH 6H");
        assertFalse(hand3.isStraightFlush());

    } // isStraightFlush()

    @Test
    void isRoyalFlush() {

        var hand1 = new PokerHand("AH KH QH TH JH");
        assertTrue(hand1.isRoyalFlush());

        var hand2 = new PokerHand("2H 3H 4H 5H 6H");
        assertFalse(hand2.isRoyalFlush());

        var hand3 = new PokerHand("AH KH QH JH TS");
        assertFalse(hand3.isRoyalFlush());

    } // isRoyalFlush()

    @Test
    void compareTo() {

        // both hands are Royal Flushes, so it's a tie
        var hand1 = new PokerHand("AH KH QH TH JH");
        var hand2 = new PokerHand("JS TS QS KS AS");
        assertEquals(0, hand1.compareTo(hand2));

        // hand1 is royal flush, hand2 is a pair
        hand1 = new PokerHand("AH KH QH JH TH");
        hand2 = new PokerHand("2S 2C QS KS AS");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // hand1 and hand1 are equal Straight Flushes
        hand1 = new PokerHand("KH QH TH JH 9H");
        hand2 = new PokerHand("KS QS TS JS 9S");
        assertEquals(0, hand1.compareTo(hand2));

        // hand1 has a higher ranking  Straight Flush than hand 2
        hand1 = new PokerHand("KH QH JH TH 9H");
        hand2 = new PokerHand("QS JS TS 9S 8S");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // hand1 has a Straight Flush and hand2 has a pair
        hand1 = new PokerHand("KH QH JH TH 9H");
        hand2 = new PokerHand("2S 2C TS 9S 8S");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have equal Four of a Kind
        hand1 = new PokerHand("KH KC KS KD 8S");
        hand2 = new PokerHand("KH KC KS KD 8D");
        assertEquals(0, hand1.compareTo(hand2));

        // both hands have Four of a Kind, the four of a kind in hand1 is bigger
        hand1 = new PokerHand("KH KC KS KD 8S");
        hand2 = new PokerHand("QH QC QS QD 8D");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have equal Four of a Kind, the single cards in hand1 is bigger
        hand1 = new PokerHand("KH KC KS KD 9S");
        hand2 = new PokerHand("KH KC KS KD 8D");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have equal full houses
        hand1 = new PokerHand("KH KC KS QD QS");
        hand2 = new PokerHand("KC KS KC QC QD");
        assertEquals(0, hand1.compareTo(hand2));

        // full houses, hand1 has a bigger three of a kind
        hand1 = new PokerHand("KH KC KS QD QS");
        hand2 = new PokerHand("JH JC JS QC QD");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // full houses, hand1 has a bigger two of a kind
        hand1 = new PokerHand("KH KC KS QD QS");
        hand2 = new PokerHand("KS KD KC 8C 8D");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have equal flushes
        hand1 = new PokerHand("KH QH 9H 5H 2H");
        hand2 = new PokerHand("KC QC 9C 5C 2C");
        assertEquals(0, hand1.compareTo(hand2));

        // both hand have flushes, hand1 is bigger
        hand1 = new PokerHand("KH QH 9H 7H 2H");
        hand2 = new PokerHand("KC QC 9C 5C 2C");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both have equal Threes of a Kind
        hand1 = new PokerHand("KH KH KH 5H 2H");
        hand2 = new PokerHand("KC KC KC 5C 2C");
        assertEquals(0, hand1.compareTo(hand2));

        // both have threes of a kinds, hand1 is bigger
        hand1 = new PokerHand("KC KS KD 7H 2H");
        hand2 = new PokerHand("KD KC KH 5C 2C");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have equal two pairs
        hand1 = new PokerHand("KH KD JH 5H 5D");
        hand2 = new PokerHand("KC KS JS 5C 5S");
        assertEquals(0, hand1.compareTo(hand2));

        // both hands have two pairs, hand1 has a bigger high pair
        hand1 = new PokerHand("KH KD JH 5H 5D");
        hand2 = new PokerHand("QC QS JS 5C 5S");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have two pairs, hand1 has a bigger low pair
        hand1 = new PokerHand("KH KD JH 5H 5D");
        hand2 = new PokerHand("KC KS JS 3C 3S");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have two pairs, hand1 has a bigger single card
        hand1 = new PokerHand("KH KD JH 5H 5D");
        hand2 = new PokerHand("KC KS 8S 5C 5S");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

        // both hands have equal junk
        hand1 = new PokerHand("KH QD JH 5H 3D");
        hand2 = new PokerHand("KC QS JS 5C 3S");
        assertEquals(0, hand1.compareTo(hand2));

        // both hands have junk, hand1 has bigger junk
        hand1 = new PokerHand("KH QD JH 7H 3D");
        hand2 = new PokerHand("KC QS JS 5C 3S");
        assertEquals(1, hand1.compareTo(hand2));
        assertEquals(-1, hand2.compareTo(hand1));

    } // compareTo()

    @Test
    void testEquals() {
    } // testEquals()

    @Test
    void canEqual() {
    } // canEqual()

    @Test
    void testHashCode() {
    } // testHashCode()

} // class PokerHandTest