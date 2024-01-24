package lesson20240124;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] data = {1, 4, 8, 0, 0, 2, 3};
//        int[] tmp = new int[data.length];
//        merge(data, tmp, 0, 2, 6);

        int[] data = {1, 4, -8, 0, 0, 2, 3, 1, 10};
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

    // space complexity O(n)
    // time complexity O(n log n)
    // O(n log n) - worst case & best case
    // best case can be O(n) when merge sort is optimised
    // stable
    public static void mergeSort(int[] data) {
        int[] tmp = new int[data.length];
        sort(data, tmp, 0, data.length - 1);
    }

    public static void sort(int[] data, int[] tmp, int start, int end) {
        if (start == end) return; // base condition

        int middle = start + (end - start) / 2;
        sort(data, tmp, start, middle);
        sort(data, tmp, middle + 1, end);
        merge(data, tmp, start, middle, end);
    }

    public static void merge(int[] data, int[] tmp, int start, int middle, int end) {
        for (int k = start; k <= end; k++) {
            tmp[k] = data[k];
        }

        int i = start;
        int j = middle + 1;
        int k = start;

        while (k <= end) {
            if (i == middle + 1) data[k++] = tmp[j++];
            else if (j == end + 1) data[k++] = tmp[i++];
            else if (tmp[i] <= tmp[j]) data[k++] = tmp[i++];
            else data[k++] = tmp[j++];
        }

    }



}
