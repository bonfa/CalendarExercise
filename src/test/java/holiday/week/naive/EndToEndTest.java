package holiday.week.naive;

import holiday.weeks.naive.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class EndToEndTest {

    private Solution solution;

    @Before
    public void setUp() {
        solution = new Solution(
                new FirstMondayOfMonth(),
                new LastSundayOfMonth(),
                new DaysFromTheFirstOfTheYear(),
                new NumberOfWeeksFromNumberOfDays()
        );
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
