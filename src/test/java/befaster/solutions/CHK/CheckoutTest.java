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
    public void compute_complex_sum() {
        assertThat(chk.checkout("ABCCCDAD"), equalTo(220));
    }

    @Test
    public void compute_tripleA() {
        assertThat(chk.checkout("AABAA"), equalTo(210));
    }

    @Test
    public void compute_doubleB() {
        assertThat(chk.checkout("DBB"), equalTo(60));
    }
}




