package two.digits.sum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TwoDigitsSumInArray {
    public int solution(int[] items) {

        Long[] longz = new Long[items.length];
        for (int i = 0; i < items.length; i++) {
            longz[i] = (long) items[i];
        }
        List<Long> longs = Arrays.asList(longz);

        List<Long> twoDigits = longs.stream().filter(this::isTwoDigits)
                .collect(Collectors.toList());

        long sum = twoDigits.stream().mapToLong(i -> i.longValue()).sum();
        return (int) sum;
    }

    private boolean isTwoDigits(Long aLong) {
        return (aLong >= 10 && aLong < 100) || (aLong > -100 && aLong <= -10);
    }


}
