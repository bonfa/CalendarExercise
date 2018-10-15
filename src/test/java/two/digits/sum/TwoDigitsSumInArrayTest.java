package two.digits.sum;

import org.junit.Before;
import org.junit.Test;
import two.digits.sum.TwoDigitsSumInArray;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TwoDigitsSumInArrayTest {

    private TwoDigitsSumInArray twoDigitsSumInArray;

    @Before
    public void setUp() {
        twoDigitsSumInArray = new TwoDigitsSumInArray();
    }

    @Test
    public void empty() {
        int[] ints = new int[0];
        assertThat(twoDigitsSumInArray.solution(ints), is(0));
    }

    @Test
    public void noTwoDigits() {
        int[] ints = new int[]{1,2,3,4,5};
        assertThat(twoDigitsSumInArray.solution(ints), is(0));
    }

    @Test
    public void oneTwoDigits() {
        int[] ints = new int[]{10,2,3,4,5};
        assertThat(twoDigitsSumInArray.solution(ints), is(10));
    }

    @Test
    public void boundaryValuesPositive() {
        int[] ints = new int[]{10,2,3,4,99};
        assertThat(twoDigitsSumInArray.solution(ints), is(109));
    }

    @Test
    public void boundaryValuesNegative() {
        int[] ints = new int[]{-10,2,3,4,-99};
        assertThat(twoDigitsSumInArray.solution(ints), is(-109));
    }

    @Test
    public void someValues() {
        int[] ints = new int[]{-10,2,3,4,-99,44,87,201};
        assertThat(twoDigitsSumInArray.solution(ints), is(22));
    }

    @Test
    public void testValues() {
        int[] ints = new int[]{-13, 900, 1, 100, 45};
        assertThat(twoDigitsSumInArray.solution(ints), is(32));
    }

    @Test
    public void v3() {
        int[] ints = new int[]{-100, 10};
        assertThat(twoDigitsSumInArray.solution(ints), is(10));
    }

    @Test
    public void v4() {
        int[] ints = new int[]{100, 10};
        assertThat(twoDigitsSumInArray.solution(ints), is(10));
    }

    @Test
    public void veryBigArray() {
        int[] ints = new int[100000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 1;
        }

        assertThat(twoDigitsSumInArray.solution(ints), is(0));
    }

    @Test
    public void veryBigValues() {
        int i1 = (int)-2147483648L;
        int i2 = (int)-2147483648L;
        int i3 = 10;
        int[] ints = new int[]{ i1, i2, i3};

        assertThat(twoDigitsSumInArray.solution(ints), is(10));
    }

}
