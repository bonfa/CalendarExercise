package holiday.week.naive;

import holiday.weeks.naive.DaysFromTheFirstOfTheYear;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DaysFromTheFirstOfTheYearTest {

    private DaysFromTheFirstOfTheYear daysFromTheFirstOfTheYear;

    @Before
    public void setUp() {
        daysFromTheFirstOfTheYear = new DaysFromTheFirstOfTheYear();
    }

    @Test
    public void january() {
        assertThat(
                daysFromTheFirstOfTheYear.from(2000, "January", 3),
                is(3)
        );
    }

    @Test
    public void february() {
        assertThat(
                daysFromTheFirstOfTheYear.from(2000, "February", 4),
                is(31 + 4)
        );
    }

    @Test
    public void marchNotLeapYear() {
        assertThat(
                daysFromTheFirstOfTheYear.from(2001, "March", 4),
                is(31 + 28 + 4)
        );
    }

    @Test
    public void decemberNotLeapYear() {
        assertThat(
                daysFromTheFirstOfTheYear.from(2001, "December", 30),
                is(364)
        );
    }

    @Test
    public void marchLeapYear() {
        assertThat(
                daysFromTheFirstOfTheYear.from(2004, "March", 4),
                is(31 + 29 + 4)
        );
    }

    @Test
    public void twentyNineOfFebruary() {
        assertThat(
                daysFromTheFirstOfTheYear.from(2000, "February", 29),
                is(31 + 29)
        );
    }

}