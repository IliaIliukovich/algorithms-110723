package lesson20240131;

import lesson20240124.Tasks;

public class QuickSelect {

    // Task: Найти k-ый по величине элемент неотсортированного массива.
    //Входные данные: Integer[] data = {1, 3, 1, 5, 0, 7, 8};
    //Результат:
    //k = 0
    //findSmallest(data, k)=0 (min)
    //k = 1
    //Результат: findSmallest(data, k)=1
    //k = 6
    //Результат: findSmallest(data, k)=8 (max)

    public static void main(String[] args) {
        int[] data = {3, 6, 0, 2, 7, 1, 4, 7, 9};

        System.out.println("Min: " + findKth(data, 0));
        System.out.println("Max: " + findKth(data, data.length - 1));
        System.out.println("Third element: " + findKth(data, 2));
    }

    public static int findKth(int[] data, int k) { // O(n)
        Tasks.shuffle(data);
        return findKth(data, k, 0, data.length - 1);
    }

    private static int findKth(int[] data, int k, int start, int end) {
//        if (start == end) return data[end]; // base condition

        int pivotIndex = QuickSort.partition(data, start, end);
        if (pivotIndex == k) return data[pivotIndex];
        else if (k < pivotIndex) {
            return findKth(data, k, start, pivotIndex - 1);
        } else {
            return findKth(data, k, pivotIndex + 1, end);
        }
    }

}
