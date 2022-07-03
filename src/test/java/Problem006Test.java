import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem006Test {

    @Test
    void getSumOfSquares() {
        Problem006 p = new Problem006();
        assertEquals(p.getSumOfSquares(1), 1);
        assertEquals(p.getSumOfSquares(2), 5);
        assertEquals(p.getSumOfSquares(3), 14);
        assertEquals(p.getSumOfSquares(4), 30);
        assertEquals(p.getSumOfSquares(5), 55);
    } // getSumOfSquares()

    @Test
    void getSquareOfTheSum() {
        Problem006 p = new Problem006();
        assertEquals(p.getSquareOfTheSum(1),1);
        assertEquals(p.getSquareOfTheSum(2),9);
        assertEquals(p.getSquareOfTheSum(3),36);
        assertEquals(p.getSquareOfTheSum(4),100);
        assertEquals(p.getSquareOfTheSum(5),225);
        assertEquals(p.getSquareOfTheSum(6),441);
        assertEquals(p.getSquareOfTheSum(7),784);
    } // getSquareOfTheSum()

    @Test
    void getSumSquareDifference() {
        Problem006 p = new Problem006();
        assertEquals(p.getSumSquareDifference(1),0);
        assertEquals(p.getSumSquareDifference(2),4);
        assertEquals(p.getSumSquareDifference(3),22);
        assertEquals(p.getSumSquareDifference(4),70);
        assertEquals(p.getSumSquareDifference(5),170);
        assertEquals(p.getSumSquareDifference(6),350);
        assertEquals(p.getSumSquareDifference(7),644);
        assertEquals(p.getSumSquareDifference(10),2640);
    } // getSumSquareDifference()

    @Test
    void getSumSquareDifferenceOptomized() {
        Problem006 p = new Problem006();
        assertEquals(p.getSumSquareDifferenceOptomized(1),0);
        assertEquals(p.getSumSquareDifferenceOptomized(2),4);
        assertEquals(p.getSumSquareDifferenceOptomized(3),22);
        assertEquals(p.getSumSquareDifferenceOptomized(4),70);
        assertEquals(p.getSumSquareDifferenceOptomized(5),170);
        assertEquals(p.getSumSquareDifferenceOptomized(6),350);
        assertEquals(p.getSumSquareDifferenceOptomized(7),644);
        assertEquals(p.getSumSquareDifferenceOptomized(10),2640);
    } // getSumSquareDifferenceOptomized()
} // class SumSquareDifferenceTest