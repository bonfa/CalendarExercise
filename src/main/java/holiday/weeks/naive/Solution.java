package holiday.weeks.naive;

public class Solution {

    private final FirstMondayOfMonth firstMondayOfMonth;
    private final LastSundayOfMonth lastSundayOfMonth;
    private final DaysFromTheFirstOfTheYear daysFromTheFirstOfTheYear;
    private final NumberOfWeeksFromNumberOfDays numberOfWeeksFromNumberOfDays;

    public Solution(FirstMondayOfMonth firstMondayOfMonth, LastSundayOfMonth lastSundayOfMonth, DaysFromTheFirstOfTheYear daysFromTheFirstOfTheYear, NumberOfWeeksFromNumberOfDays numberOfWeeksFromNumberOfDays) {
        this.firstMondayOfMonth = firstMondayOfMonth;
        this.lastSundayOfMonth = lastSundayOfMonth;
        this.daysFromTheFirstOfTheYear = daysFromTheFirstOfTheYear;
        this.numberOfWeeksFromNumberOfDays = numberOfWeeksFromNumberOfDays;
    }

    public int solution(int year,
                        String beginningMonth,
                        String endingMonth,
                        String firstOfJanuaryDayName) {

        return numberOfWeeksFromNumberOfDays.from(
                daysFromTheFirstOfTheYear.from(year, endingMonth, lastSundayOfMonth.from(year, endingMonth, firstOfJanuaryDayName)) -
                        daysFromTheFirstOfTheYear.from(year, beginningMonth, firstMondayOfMonth.from(year, beginningMonth, firstOfJanuaryDayName))
        );
    }
}
