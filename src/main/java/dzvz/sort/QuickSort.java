package dzvz.sort;

/**
 * Created by dzmirtyviarzhbitski on 11/22/15.
 *
 * Algorithm (nlogn):pick the pivot (middle), partition the array, move elements less the pivot left and more than pivot right, sort recursively
 */
public class QuickSort {

    public static void sort(int[] array) {

        if (array != null && array.length > 1) {
            int low = 0;
            int high = array.length - 1;
            sort(array, low, high);
        }
    }

    private static void sort(int[] array, int low, int high) {
        if (high - low > 0) {
            int pivotPosition = partition(array, low, high);
            sort(array, low, pivotPosition - 1);
            sort(array, pivotPosition + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivotPosition = (high + low)/2; // (high + low) / 2 = low + (high - low)/2 or it is possible to use random * new Random().nextInt(high)*/;
        int pivot = array[pivotPosition];
        int i = low;
        int j = high;
        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
                //handle duplicates [0 0 4 2] -> [0 0] - will never end
                //
                if (array[i] == array[j]) {
                    i++;
                }
            }
        }
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
