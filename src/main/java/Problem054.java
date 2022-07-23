/*
ProjectEuler.org
Problem 54 - Poker Hands
In the card game poker, a hand consists of five cards and are ranked,
from lowest to highest, in the following way:

High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins;
for example, a pair of eights beats a pair of fives (see example 1 below).
But if two ranks tie, for example, both players have a pair of queens, then highest cards
in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards
are compared, and so on.

Consider the following five hands dealt to two players:

Hand	 	Player 1	 	Player 2	 	Winner
1	 	5H 5C 6S 7S KD   2C 3S 8S 8D TD     Player 2
2       5D 8C 9S JS AC   2C 5C 7D 8S QH     Player 1

The file, poker.txt, contains one-thousand random hands dealt to two players.
Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards
and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or
repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

How many hands does Player 1 win?
 */

import lombok.EqualsAndHashCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

enum PokerHandRanking {
    HIGH_CARD, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND,
    STRAIGHT_FLUSH, ROYAL_FLUSH
}


/**
 * CARD
 */
@EqualsAndHashCode
class Card implements Comparable<Card> {
    public final static int MAX_RANK_VALUE = 14;
    private int rankValue;  // 10 == 10, Jacks == 11, Queens == 12, Kings == 13, Aces == 14
    private char rankChar;  // T == 10, Jacks == J, Queens == Q, Kings == K, Aces == A
    private char suit;      // C == Clubs, H == Hearts, D == Diamonds, S == Spades

    Card(final String s) {
        setRank(s);
        setSuit(s);
    } // Card()

    @Override
    public String toString() {
        return "" + this.rankChar + this.suit;
    } // toString()

    // saves the char rank, converts the char rank to an int rank to make comparisons easier later
    private void setRank(String s) {
        this.rankChar = s.charAt(0);
        switch (this.rankChar) {
            case '2' -> this.rankValue = 2;
            case '3' -> this.rankValue = 3;
            case '4' -> this.rankValue = 4;
            case '5' -> this.rankValue = 5;
            case '6' -> this.rankValue = 6;
            case '7' -> this.rankValue = 7;
            case '8' -> this.rankValue = 8;
            case '9' -> this.rankValue = 9;
            case 'T' -> this.rankValue = 10;
            case 'J' -> this.rankValue = 11;
            case 'Q' -> this.rankValue = 12;
            case 'K' -> this.rankValue = 13;
            case 'A' -> this.rankValue = 14;
        } // switch
    } // setRank()

    public int getRankValue() {
        return this.rankValue;
    } // getRankValue()

    public char getSuit() {
        return this.suit;
    } // getSuit()

    private void setSuit(String s) {
        this.suit = s.charAt(1);
    } // setSuit()

    // when sorted, cards should be ordered by rank only (high to low), suits are ignored
    @Override
    public int compareTo(Card card) {
        return card.getRankValue() - this.rankValue;
    } // compareTo()

} // class Card


/**
 * HAND
 */
class PokerHand implements Comparable<PokerHand> {
    public final int MAX_CARDS_PER_HAND = 5;
    private final Card[] cards = new Card[this.MAX_CARDS_PER_HAND];
    private final int numOfCardsInHand;
    // RankTallies is an array of ints that records the count of each rank.
    // For example, if we had a full house KH KD KC 8S 8D, we would have three kings and two eights.
    // We often scan this array to determine if we have four of a kind, three of a kind, etc.
    // We also use it to determine who has the highest rank.
    // For example, let's assume hand1 is KH KD JC 8S 8D and hand2 is KS KC 7C 4C 4S.
    // Both hands have two pairs. During the tiebreak evaluation, we determine hands have a pair of kings
    // for their high pair. Next, we determine for the low pair, hand1 has eights and hand2 has fours.
    // In this case, hand1 wins because its low pair have a higher rank.
    private final int[] rankTallies = new int[Card.MAX_RANK_VALUE + 1];
    private final PokerHandRanking pokerHandRanking;


    // expects a string that looks like "KH KD KC 8S 8D".  Each pairing of chars represent a card.
    PokerHand(final String s) {
        String[] cardsStr = s.split(" ");
        if (cardsStr.length != 5) throw new IllegalStateException("expecting five card strings");

        this.numOfCardsInHand = cardsStr.length;
        for (int i = 0; i < this.MAX_CARDS_PER_HAND; i++) {
            Card card = new Card(cardsStr[i]);
            this.cards[i] = card;
            this.rankTallies[card.getRankValue()]++;        // count how many kings, queens, etc.
        } // for cardStr
        // after cards are inserted into the hand, sort the cards high to low
        Arrays.sort(this.cards);
        // figure out if this hand is a full house, flush, etc.
        this.pokerHandRanking = getPokerHandRanking();
    } // PokerHand()

    // Simply gets the ranking for a single hand.
    private PokerHandRanking getPokerHandRanking() {
        if (isRoyalFlush()) return PokerHandRanking.ROYAL_FLUSH;
        if (isStraightFlush()) return PokerHandRanking.STRAIGHT_FLUSH;
        if (isFourOfAKind()) return PokerHandRanking.FOUR_OF_A_KIND;
        if (isFullHouse()) return PokerHandRanking.FULL_HOUSE;
        if (isFlush()) return PokerHandRanking.FLUSH;
        if (isStraight()) return PokerHandRanking.STRAIGHT;
        if (isThreeOfAKind()) return PokerHandRanking.THREE_OF_A_KIND;
        if (isTwoPairs()) return PokerHandRanking.TWO_PAIRS;
        if (isOnePair()) return PokerHandRanking.ONE_PAIR;
        return PokerHandRanking.HIGH_CARD;
    } //  getPokerHandRanking()

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof PokerHand otherHand)) return false;

        if (this.numOfCardsInHand != otherHand.numOfCardsInHand) return false;
        if (this.pokerHandRanking != otherHand.pokerHandRanking) return false;

        for (int i = 0; i < this.MAX_CARDS_PER_HAND; i++) {
            if (this.cards[i] != otherHand.cards[i]) return false;
        }
        return true;
    } // equals()

    @Override
    public int hashCode() {
        int result = this.MAX_CARDS_PER_HAND;
        result = 31 * result + Arrays.hashCode(this.cards);
        result = 31 * result + this.numOfCardsInHand;
        result = 31 * result + Arrays.hashCode(this.rankTallies);
        result = 31 * result + getPokerHandRanking().hashCode();
        return result;
    } // hashCode()

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var card : this.cards) {
            sb.append(card).append(" ");
        } // for card
        return sb.toString();
    } // toString()

    // compares one hand to another and determines the winner (or tie)
    @Override
    public int compareTo(PokerHand otherHand) {
        if (this.pokerHandRanking.ordinal() > otherHand.pokerHandRanking.ordinal()) return 1;
        if (this.pokerHandRanking.ordinal() < otherHand.pokerHandRanking.ordinal()) return -1;

        // Both hands have the same poker hand ranking value(e.g., both have full houses).
        // Now we need to call the appropriate tiebreaker.
        return switch (this.pokerHandRanking) {
            case ROYAL_FLUSH -> 0;  // there are no tiebreakers for royal flushes
            case STRAIGHT_FLUSH, STRAIGHT -> StraightTieBreaker(otherHand);
            case FOUR_OF_A_KIND -> FourOfAKindTieBreaker(otherHand);
            case FULL_HOUSE -> FullHouseTieBreaker(otherHand);
            case FLUSH, HIGH_CARD -> singleCardsTieBreaker(otherHand);
            case THREE_OF_A_KIND -> ThreeOfAKindTieBreaker(otherHand);
            case TWO_PAIRS -> TwoPairsTieBreaker(otherHand);
            case ONE_PAIR -> OnePairTieBreaker(otherHand);
        };
    } // compareTo()

    // a generic method used to find twos of a kind, threes of a kind, and fours of a kind
    private int compareNOfAKind(PokerHand otherHand, final int n) {
        for (int i = Card.MAX_RANK_VALUE; i > 0; i--) {
            if ((this.rankTallies[i] == n) && (otherHand.rankTallies[i] == n)) {
                return 0;
            } else if (this.rankTallies[i] == n) {
                return 1;
            } else if (otherHand.rankTallies[i] == n) {
                return -1;
            }
        } // for i
        throw new IllegalStateException("hand missing an n kind");
    } // compareThreeOfAKind()

    // go through the single cards to figure out which hand has the highest
    private int singleCardsTieBreaker(PokerHand otherHand) {
        for (int i = Card.MAX_RANK_VALUE; i > 0; i--) {
            if ((this.rankTallies[i] == 1) && (otherHand.rankTallies[i] != 1)) {
                return 1;
            } else if ((this.rankTallies[i] != 1) && (otherHand.rankTallies[i] == 1)) {
                return -1;
            }
        } // for i
        return 0;
    } // singleCardsTieBreaker()

    private int OnePairTieBreaker(PokerHand otherHand) {
        int result = compareNOfAKind(otherHand, 2);
        if (result == 0) {
            result = singleCardsTieBreaker(otherHand);
        }
        return result;
    } // OnePairTieBreaker()

    private int TwoPairsTieBreaker(PokerHand otherHand) {
        for (int i = Card.MAX_RANK_VALUE; i > 0; i--) {
            if ((this.rankTallies[i] == 2) && (otherHand.rankTallies[i] != 2)) {
                return 1;
            } else if ((this.rankTallies[i] != 2) && (otherHand.rankTallies[i] == 2)) {
                return -1;
            }
        } // for i
        // since both hands have the same two pair (e.g., two fives and two eights)
        // we have to look at the remaining single card to determine the winner
        return singleCardsTieBreaker(otherHand);
    } // TwoPairsTieBreaker()

    private int ThreeOfAKindTieBreaker(PokerHand otherHand) {
        int result = compareNOfAKind(otherHand, 3);
        if (result == 0) {
            // Since both hands have the same three of a kind (e.g., three kings),
            // we have to look at the remaining single cards to determine the winner.
            // NOTE: In real poker with a single deck, since there are only four of each rank in a deck,
            // (e.g., four kings) this condition could never happen.  If you played with multiple decks, then...
            result = singleCardsTieBreaker(otherHand);
        }
        return result;
    } // ThreeOfAKindTieBreaker()

    private int FullHouseTieBreaker(PokerHand otherHand) {
        int result = compareNOfAKind(otherHand, 3);
        if (result == 0) {
            // Since both hands have the same three of a kind (e.g., three kings),
            // we have to look at the pair to determine the winner.
            // NOTE: Again, in real poker with a single deck, since there are only four of each rank in a deck,
            // (e.g., four kings) this condition could never happen.  If you played with multiple decks, then...
            result = compareNOfAKind(otherHand, 2);
        }
        return result;
    } // FullHouseTieBreaker()

    private int FourOfAKindTieBreaker(PokerHand otherHand) {
        int result = compareNOfAKind(otherHand, 4);
        if (result == 0) {
            // Since both hands have the same four of a kind (e.g., four kings),
            // we have to look at the pair to determine the winner.
            // NOTE: Again, in real poker with a single deck, since there are only four of each rank in a deck,
            // (e.g., four kings) this condition could never happen.  If you played with multiple decks, then...
            result = singleCardsTieBreaker(otherHand);
        }
        return result;
    } // FourOfAKindTieBreak()

    // tie breaking a Straight Flush and Straight works the same way
    private int StraightTieBreaker(PokerHand otherHand) {
        // compare the rankings of their highest cards
        // for example a king is higher than a jack
        return this.cards[0].getRankValue() - otherHand.cards[0].getRankValue();
    } // StraightFlushTieBreak

    // returns true if one pair, false if full house or two pairs
    public boolean isOnePair() {
        int numOfPairs = 0;
        int numOfThreeOfAKind = 0;
        for (var rankTally : this.rankTallies) {
            if (rankTally == 2) numOfPairs++;
            if (rankTally == 3) numOfThreeOfAKind++;
        } // for count
        return (numOfPairs == 1) && (numOfThreeOfAKind == 0);
    } // isOnePair()

    public boolean isTwoPairs() {
        int numOfPairs = 0;
        for (var rankTally : this.rankTallies) {
            if (rankTally == 2) numOfPairs++;
        } // for count
        return (numOfPairs == 2);
    } // isTwoPairs()

    // true if three of a kind, false if full house
    public boolean isThreeOfAKind() {
        int numOfPairs = 0;
        int numOfThreeOfAKind = 0;
        for (var rankTally : this.rankTallies) {
            if (rankTally == 2) numOfPairs++;
            if (rankTally == 3) numOfThreeOfAKind++;
        } // for count
        return (numOfPairs == 0) && (numOfThreeOfAKind == 1);
    } // isThreeOfAKind()

    // Returns true for straights, straight flushes, and royal flushes.
    public boolean isStraight() {
        // since the cards are already sorted high to low (left to right),
        // each card should be lower than the previous card by one rank
        int previousRank = this.cards[0].getRankValue();
        for (int i = 1; i < this.MAX_CARDS_PER_HAND; i++) {
            if ((previousRank - this.cards[i].getRankValue()) != 1) return false;
            previousRank = this.cards[i].getRankValue();
        } // for i
        return true;
    } // isStraight()

    // flush is all cards are of the same suit
    public boolean isFlush() {
        char suit = this.cards[0].getSuit();
        for (int i = 1; i < this.numOfCardsInHand; i++) {
            if (this.cards[i].getSuit() != suit) return false;
        } // for i
        return true;
    } // isFlush()

    // full house is a three of a kind and a two of a kind
    public boolean isFullHouse() {
        boolean foundTwoOfAKind = false;
        boolean foundThreeOfAKind = false;
        for (var rankTally : this.rankTallies) {
            if (rankTally == 2) foundTwoOfAKind = true;
            if (rankTally == 3) foundThreeOfAKind = true;
        } // for count
        return foundTwoOfAKind && foundThreeOfAKind;
    } // isFullHouse()

    public boolean isFourOfAKind() {
        for (var rankTally : this.rankTallies) {
            if (rankTally == 4) return true;
        } // for count
        return false;
    } // isFourOfAKind()

    public boolean isStraightFlush() {
        return isStraight() && isFlush();
    } // isStraightFlush()

    public boolean isRoyalFlush() {
        boolean highCardIsAce = (this.cards[0].getRankValue() == Card.MAX_RANK_VALUE);
        return highCardIsAce && isStraight() && isFlush();
    } //  isRoyalFlush()

} // class PokerHand


/**
 * Problem054
 */
public class Problem054 {

    // read through the data file, extract and evaluate the hands, and report how many times play 1 won
    public static void main(String[] args) {
        String filename = "d:\\p054_poker.txt";

        int player1Wins = 0;

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                // there should be 1,000 rows of text
                // each row should contain enough cards for two hands
                String aRowOfCards = scanner.nextLine();

                String player1Cards = aRowOfCards.substring(0,14);
                String player2Cards = aRowOfCards.substring(15);

                PokerHand player1Hand = new PokerHand(player1Cards);
                PokerHand player2Hand = new PokerHand(player2Cards);

                if (player1Hand.compareTo(player2Hand) > 0) {
                    player1Wins++;
                }

            } // while

            System.out.println("Player 1 won " + player1Wins + " games");

            } catch (FileNotFoundException e) {
                System.out.println("data file not found, " + filename);
            } // catch

    } // main()

} // class Problem054
