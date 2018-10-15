package holiday.weeks.naive;

import java.util.HashMap;

public class LastSundayOfMonth {

    private static final HashMap<String, int[]> LAST_SUNDAY_OF_MONTH_FOR_FIRST_DAY_OF_YEAR = new HashMap<String, int[]>() {{
        put("Tuesday", new int[]{27, 24, 31, 28, 26, 30, 28, 25, 29, 27, 24, 29});
        put("Sunday", new int[]{29, 26, 26, 30, 28, 25, 30, 27, 24, 29, 26, 31});
        put("Friday", new int[]{31, 28, 28, 25, 30, 27, 25, 29, 26, 31, 28, 26});
        put("Wednesday", new int[]{26, 23, 30, 27, 25, 29, 27, 31, 28, 26, 30, 28});
        put("Monday", new int[]{28, 25, 25, 29, 27, 24, 29, 26, 30, 28, 25, 30});
        put("Saturday", new int[]{30, 27, 27, 24, 29, 26, 31, 28, 25, 30, 27, 25});
        put("Thursday", new int[]{25, 22, 29, 26, 31, 28, 26, 30, 27, 25, 29, 27});
    }};

    private static final HashMap<String, int[]> LAST_SUNDAY_OF_MONTH_FOR_FIRST_DAY_OF_LEAP_YEAR = new HashMap<String, int[]>() {{
        put("Tuesday", new int[]{27, 24, 30, 27, 25, 29, 27, 31, 28, 26, 30, 28});
        put("Sunday", new int[]{29, 26, 25, 29, 27, 24, 29, 26, 30, 28, 25, 30});
        put("Friday", new int[]{31, 28, 27, 24, 29, 26, 31, 28, 25, 30, 27, 25});
        put("Wednesday", new int[]{26, 23, 29, 26, 31, 28, 26, 30, 27, 25, 29, 27});
        put("Monday", new int[]{28, 25, 31, 28, 26, 30, 28, 25, 29, 27, 24, 29});
        put("Saturday", new int[]{30, 27, 26, 30, 28, 25, 30, 27, 24, 29, 26, 31});
        put("Thursday", new int[]{25, 29, 28, 25, 30, 27, 25, 29, 26, 31, 28, 26});
    }};

    public int from(int year, String month, String nameOfFirstDayOfYear) {
        if (isLeap(year)) {
            return LAST_SUNDAY_OF_MONTH_FOR_FIRST_DAY_OF_LEAP_YEAR.get(nameOfFirstDayOfYear)[FirstMondayOfMonth.MONTH_INDEX.get(month)];
        }

        return LAST_SUNDAY_OF_MONTH_FOR_FIRST_DAY_OF_YEAR.get(nameOfFirstDayOfYear)[FirstMondayOfMonth.MONTH_INDEX.get(month)];
    }

    private boolean isLeap(int year) {
        //simplification got from constraint
        return year % 4 == 0;
    }
}
