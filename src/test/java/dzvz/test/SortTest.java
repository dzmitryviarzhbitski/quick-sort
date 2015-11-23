package dzvz.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static dzvz.sort.QuickSort.sort;

/**
 * Created by dzmirtyviarzhbitski on 11/22/15.
 */
public class SortTest {

    public static final int RANDOM_ARRAY_SIZE = 10;
    public static final int RANDOM_TEST_RETRY = 20;

    @Test
    public void testOrderedOdd() {
        sortAndAssert(new int[]{3, 4, 5});
    }

    @Test
    public void testNotOrderedOdd() {
        sortAndAssert(new int[]{5, 4, 3});
    }

    @Test
    public void testOrderedEven() {
        sortAndAssert(new int[]{3, 4, 5, 6});
    }

    @Test
    public void testNotOrderedEven() {
        sortAndAssert(new int[]{6, 3, 5, 4});
    }

    @Test
    public void testDuplicatesOdd() {
        sortAndAssert(new int[]{4, 4, 4, 4});
    }

    @Test
    public void testDuplicatesEven() {
        sortAndAssert(new int[]{4, 4, 4, 4});
    }


    @Test
    public void test() {
        sortAndAssert(new int[]{3, 2, 4, 0, 0});
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < RANDOM_TEST_RETRY; i++) {
            sortAndAssert(getRandomArray());
        }
    }

    private int[] getRandomArray() {
        int[] array = new int[RANDOM_ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < RANDOM_ARRAY_SIZE; i++) {
            array[i] = Math.abs(random.nextInt(RANDOM_ARRAY_SIZE));
        }
        return array;
    }

    private void sortAndAssert(int[] array) {
        System.out.println("Unsorted");
        print(array);
        sort(array);
        System.out.println("Sorted");
        print(array);
        validate(array);
    }

    private void print(int[] array) {
        StringBuilder b = new StringBuilder();
        for (int i : array) {
            b.append(i);
            b.append(" ");
        }
        System.out.println(b);
    }

    private void validate(int[] array) {
        Integer previous = null;
        for (int i : array) {
            if (previous != null) {
                Assert.assertTrue(previous <= i);
            }
            previous = i;
        }
    }
}
