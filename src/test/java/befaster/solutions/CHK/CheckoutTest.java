package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutTest {
    private CheckoutSolution chk;

    @BeforeEach
    public void setUp() {
        chk = new CheckoutSolution();
    }


//    Our price table and offers:
//            +------+-------+----------------+
//            | Item | Price | Special offers |
//            +------+-------+----------------+
//            | A    | 50    | 3A for 130     |
//            | B    | 30    | 2B for 45      |
//            | C    | 20    |                |
//            | D    | 15    |                |
//            +------+-------+----------------+
    @Test
    public void compute_basic_sum() {
        assertThat(chk.checkout("ABC"), equalTo(100));
    }


    @Test
    public void compute_tripleA() {
        assertThat(chk.checkout("AABAA"), equalTo(210));
    }

    @Test
    public void compute_doubleB() {
        assertThat(chk.checkout("DBB"), equalTo(60));
    }

    @Test
    public void compute_complex_sum() {
        assertThat(chk.checkout("ABCDDABCAABBABBAA"), equalTo(505));
    }


    @Test
    public void bad_input() {
        assertThat(chk.checkout("AAhB"), equalTo(-1));
    }

    @Test
    public void testE() {
        assertThat(chk.checkout("EEE"), equalTo(120));
    }

    @Test
    public void testEAndB() {
        assertThat(chk.checkout("EEEEBB"), equalTo(160));
    }

    @Test
    public void testEAndB_complex() {
        assertThat(chk.checkout("EEEEBBBABECCDBAA"), equalTo(460));
    }

    @Test
    public void testMultipleA() {
        assertThat(chk.checkout("AAAAAAAAA"), equalTo(380));
    }

    @Test
    public void testF() {
        assertThat(chk.checkout("FFFFFF"), equalTo(40));
    }
}

