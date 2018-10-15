package holiday.weeks.naive;

public class DaysFromTheFirstOfTheYear {

    private static final int[] DAYS_PER_MONTHS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int from(int year, String month, int dayInMonth) {
        Integer monthIndex = FirstMondayOfMonth.MONTH_INDEX.get(month);
        int sum = 0;
        for (int i = 0; i < monthIndex; i++) {
            sum += DAYS_PER_MONTHS[i];
        }

        if (isLeap(year) && monthIndex > FirstMondayOfMonth.MONTH_INDEX.get("February")) {
            sum = sum + 1;
        }

        return sum + dayInMonth;
    }

    private boolean isLeap(int year) {
        return year % 4 == 0;
    }

}
