package lesson20240131;

import lesson20240124.Tasks;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
//        int[] data = {4, 3, 3, 2, 6, 5, 8, 1, 2};
        int[] data = {3, 3, 3, 3, 3, 3, 3, 1, 7};

//        System.out.println(partition(data, 0, data.length - 1));


        quickSort(data);

        System.out.println(Arrays.toString(data));
    }


    // unstable
    // space complexity O(1)
    // time complexity
    //  - best case O(n log n)
    //  - worst case O(n^2)
    //  - in average O(n log n)
    public static void quickSort(int[] data) {
        Tasks.shuffle(data);  // O(n)
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) return; // base condition
        int pivotIndex = partition(data, start, end);
        quickSort(data, start, pivotIndex - 1);
        quickSort(data, pivotIndex + 1, end);
    }

    private static int partition(int[] data, int start, int end){
        int pivot = data[start];
        int i = start;
        int j = end + 1;

        while (i <= j) {
            while (data[++i] < pivot) {
                if (i == end) break;
            }

            while (data[--j] > pivot) {
                if (j == start) break;
            }

            if (i >= j) break;
            swap(data, i, j);
        }

        swap(data, start, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }


}
