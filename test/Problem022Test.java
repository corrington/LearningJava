import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem022Test {

    @Test
    void readNames() {
    } //  readNames()

    @Test
    void scoreName() {
        Problem022 p = new Problem022();
        assertEquals(53, p.scoreName("COLIN"));
        assertEquals(64, p.scoreName("PETER"));
        assertEquals(39, p.scoreName("AMBER"));
    } // scoreName()

    @Test
    void scoreNames() {
    } // scoreNames()
} // class Problem022Test