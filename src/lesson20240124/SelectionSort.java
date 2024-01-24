package lesson20240124;

import java.util.Arrays;
import java.util.Comparator;

public class SelectionSort {

    public static void main(String[] args) {
        Integer[] data = new Integer[] {0, 12, 12, -9, 8, -10, 121};
        selectionSort(data, Comparator.naturalOrder());
        System.out.println(Arrays.toString(data));
    }

    // space complexity O(1)
    // time complexity O(n^2)
    public static void selectionSort(Object[] data, Comparator comparator) {
        for (int i = 0; i < data.length; i++) {
            Object min = data[i];
            int indMin = i;
            for (int j = i + 1; j < data.length; j++) {
                if (comparator.compare(data[j], min) < 0) {
                    min = data[j];
                    indMin = j;
                }
            }
            swap(data, i, indMin);
        }
    }

    private static void swap(Object[] data, int i, int j) {
        Object tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
