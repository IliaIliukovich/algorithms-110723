package lesson20240207;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        Integer[] data = {3, 1, 2, 5, 4};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void heapSort(Comparable[] a) {
        int n = a.length;
        for (int k = n/2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            swap(a, 1, n);
            sink(a, 1, --n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && a[j - 1].compareTo(a[j]) < 0) j++;
            if (a[k - 1].compareTo(a[j - 1]) >= 0) break;
            swap(a, k ,j);
            k = j;
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
    }

}
