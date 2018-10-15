package holiday.weeks.library;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

import static java.time.temporal.ChronoUnit.WEEKS;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.lastInMonth;

public class SolutionLibrary {

    private static final HashMap<String, Integer> YEARS_FOR_STARTING_DAY = new HashMap<String, Integer>() {{
        put("Monday", 2001);
        put("Tuesday", 2002);
        put("Wednesday", 2003);
        put("Thursday", 2009);
        put("Friday", 2010);
        put("Saturday", 2005);
        put("Sunday", 2006);
    }};

    private static final HashMap<String, Integer> LEAP_YEARS_FOR_STARTING_DAY = new HashMap<String, Integer>() {{
        put("Monday", 2024);
        put("Tuesday", 2008);
        put("Wednesday", 2020);
        put("Thursday", 2004);
        put("Friday", 2016);
        put("Saturday", 2028);
        put("Sunday", 2012);
    }};

    private static final HashMap<String, Integer> MONTH_INDEX = new HashMap<String, Integer>() {{
        put("January", 0);
        put("February", 1);
        put("March", 2);
        put("April", 3);
        put("May", 4);
        put("June", 5);
        put("July", 6);
        put("August", 7);
        put("September", 8);
        put("October", 9);
        put("November", 10);
        put("December", 11);
    }};


    public int solution(int year,
                        String beginningMonth,
                        String endingMonth,
                        String firstOfJanuaryDayName) {

        int referenceYear = getRealYearWithStartingDay(year, firstOfJanuaryDayName);

        LocalDate firstOfTheYear = LocalDate.of(referenceYear, 1, 1);
        int beginningMonthIndex = MONTH_INDEX.get(beginningMonth);
        int endingMonthIndex = MONTH_INDEX.get(endingMonth);

        LocalDate firstMondayOfBeginningMonth = firstOfTheYear.withMonth(beginningMonthIndex + 1).with(firstInMonth(DayOfWeek.MONDAY));
        LocalDate lastSundayOfEndingMonth = firstOfTheYear.withMonth(endingMonthIndex + 1).with(lastInMonth(DayOfWeek.SUNDAY));

        return (int) WEEKS.between(firstMondayOfBeginningMonth, lastSundayOfEndingMonth.plusDays(1));
    }

    private int getRealYearWithStartingDay(int year, String firstOfJanuaryDayName) {
        if (isLeap(year)) {
            return LEAP_YEARS_FOR_STARTING_DAY.get(firstOfJanuaryDayName);
        }

        return YEARS_FOR_STARTING_DAY.get(firstOfJanuaryDayName);
    }

    private boolean isLeap(int year) {
        return year % 4 == 0;
    }
}
