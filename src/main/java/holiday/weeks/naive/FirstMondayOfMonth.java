package holiday.weeks.naive;

import java.util.HashMap;

public class FirstMondayOfMonth {

    public static final HashMap<String, Integer> MONTH_INDEX = new HashMap<String, Integer>() {{
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

    private static final HashMap<String, int[]> FIRST_MONDAYS_OF_MONTH_FOR_FIRST_DAY_OF_YEAR = new HashMap<String, int[]>() {{
        put("Monday", new int[]{1, 5, 5, 2, 7, 4, 2, 6, 3, 1, 5, 3});
        put("Tuesday", new int[]{7, 4, 4, 1, 6, 3, 1, 5, 2, 7, 4, 2});
        put("Wednesday", new int[]{6, 3, 3, 7, 5, 2, 7, 4, 1, 6, 3, 1});
        put("Thursday", new int[]{5, 2, 2, 6, 4, 1, 6, 3, 7, 5, 2, 7});
        put("Friday", new int[]{4, 1, 1, 5, 3, 7, 5, 2, 6, 4, 1, 6});
        put("Saturday", new int[]{3, 7, 7, 4, 2, 6, 4, 1, 5, 3, 7, 5});
        put("Sunday", new int[]{2, 6, 6, 3, 1, 5, 3, 7, 4, 2, 6, 4});
    }};

    private static final HashMap<String, int[]> FIRST_MONDAYS_OF_MONTH_FOR_FIRST_DAY_OF_LEAP_YEAR = new HashMap<String, int[]>() {{
        put("Monday", new int[]{1, 5, 4, 1, 6, 3, 1, 5, 2, 7, 4, 2});
        put("Tuesday", new int[]{7, 4, 3, 7, 5, 2, 7, 4, 1, 6, 3, 1});
        put("Wednesday", new int[]{6, 3, 2, 6, 4, 1, 6, 3, 7, 5, 2, 7});
        put("Thursday", new int[]{5, 2, 1, 5, 3, 7, 5, 2, 6, 4, 1, 6});
        put("Friday", new int[]{4, 1, 7, 4, 2, 6, 4, 1, 5, 3, 7, 5});
        put("Saturday", new int[]{3, 7, 6, 3, 1, 5, 3, 7, 4, 2, 6, 4});
        put("Sunday", new int[]{2, 6, 5, 2, 7, 4, 2, 6, 3, 1, 5, 3});
    }};


    public int from(int year, String month, String nameOfFirstDayOfYear) {
        if (isLeap(year)) {
            return FIRST_MONDAYS_OF_MONTH_FOR_FIRST_DAY_OF_LEAP_YEAR.get(nameOfFirstDayOfYear)[MONTH_INDEX.get(month)];
        }

        return FIRST_MONDAYS_OF_MONTH_FOR_FIRST_DAY_OF_YEAR.get(nameOfFirstDayOfYear)[MONTH_INDEX.get(month)];
    }

    private boolean isLeap(int year) {
        //simplification got from constraint
        return year % 4 == 0;
    }
}
