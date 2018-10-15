package holiday.week.library;

import holiday.weeks.library.SolutionLibrary;
import holiday.weeks.naive.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EndToEndTest {

    private SolutionLibrary solution;

    @Before
    public void setUp() {
        solution = new SolutionLibrary();
    }

    @Test
    public void validation() {
        assertThat(
                solution.solution(
                        2014,
                        "April",
                        "May",
                        "Wednesday"
                ),
                is(7)
        );
    }

    @Test
    public void leapYear() {
        assertThat(
                solution.solution(
                        2004,
                        "April",
                        "May",
                        "Wednesday"
                ),
                is(8)
        );
    }

    @Test
    public void leapFebruary() {
        assertThat(
                solution.solution(
                        2004,
                        "February",
                        "February",
                        "Thursday"
                ),
                is(4)
        );
    }
}
