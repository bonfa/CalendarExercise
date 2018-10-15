package holiday.week.naive;

import holiday.weeks.naive.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class SolutionTest {

    private FirstMondayOfMonth firstMondayOfMonth;
    private LastSundayOfMonth lastSundayOfMonthProvider;
    private DaysFromTheFirstOfTheYear daysFromTheFirstOfTheYear;
    private NumberOfWeeksFromNumberOfDays numberOfWeeksFromNumberOfDays;

    private Solution solution;

    @Before
    public void setUp() {
        firstMondayOfMonth = mock(FirstMondayOfMonth.class);
        lastSundayOfMonthProvider = mock(LastSundayOfMonth.class);
        daysFromTheFirstOfTheYear = mock(DaysFromTheFirstOfTheYear.class);
        numberOfWeeksFromNumberOfDays = mock(NumberOfWeeksFromNumberOfDays.class);

        solution = new Solution(firstMondayOfMonth, lastSundayOfMonthProvider, daysFromTheFirstOfTheYear, numberOfWeeksFromNumberOfDays);
    }

    @Test
    public void interaction() {
        when(firstMondayOfMonth.from(2001, "January", "Monday")).thenReturn(4);
        when(lastSundayOfMonthProvider.from(2001, "March", "Monday")).thenReturn(6);
        when(daysFromTheFirstOfTheYear.from(2001, "January", 4)).thenReturn(3);
        when(daysFromTheFirstOfTheYear.from(2001, "March", 6)).thenReturn(83);
        when(numberOfWeeksFromNumberOfDays.from(80)).thenReturn(11);

        assertThat(
                solution.solution(2001, "January", "March", "Monday"),
                is(11)
        );
    }
}
