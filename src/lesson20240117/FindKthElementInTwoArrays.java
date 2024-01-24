package lesson20240117;

import java.util.Arrays;

public class FindKthElementInTwoArrays {

    public static void main(String[] args) {
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        System.out.println(findBySorting(array1, array2, k));
        System.out.println(findKthElement(array1, array2, k));
    }

    public static int findBySorting(int[] array1, int[] array2, int k) { // O((n + m) * log(n + m))
        int[] mergedArray = new int[array1.length + array2.length]; // O(n + m)
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
        Arrays.sort(mergedArray); // O((n + m) * log(n + m))
        return mergedArray[k - 1];
    }

    public static int findKthElement(int[] array1, int[] array2, int k) { // O(k)
        int m = array1.length;
        int n = array2.length;

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < m && j < n) {
            if (array1[i] < array2[j]) {
                count++;
                if (count == k) {
                    return array1[i];
                }
                i++;
            } else {
                count++;
                if (count == k) {
                    return array2[j];
                }
                j++;
            }
        }

        while (i < m) {
            count++;
            if (count == k) {
                return array1[i];
            }
            i++;
        }

        while (j < n) {
            count++;
            if (count == k) {
                return array2[j];
            }
            j++;
        }
        return -1;
    }

}
