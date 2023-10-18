package lesson20231018;

import java.util.Arrays;
import java.util.Random;

public class SortAlgorithms {

    public static void main(String[] args) {
        int[] data = new int[] {0, 12, 12, -9, 8, -10, 121};
        sortBruteForce(data);
        System.out.println(Arrays.toString(data));

        data = new int[] {0, 12, 12, -9, 8, -10, 121};
        selectionSort(data);
        System.out.println(Arrays.toString(data));

        int n = 100_000;
        data = generateRandomArray(n);

        long start = System.nanoTime();
        selectionSort(data);
        long end = System.nanoTime();
        System.out.println("Time elapsed, selectionSort: " + (end - start));

        data = generateRandomArray(n);
        start = System.nanoTime();
        Arrays.sort(data);
        end = System.nanoTime();
        System.out.println("Time elapsed, Arrays.sort(): " + (end - start));

    }

    private static int[] generateRandomArray(int n) {
        int[] data = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    public static void sortBruteForce(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    data[j] = data[i];
                    data[i] = min;
                }
            }
        }
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int indMin = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    indMin = j;
                }
            }
            int tmp = data[i];
            data[i] = data[indMin];
            data[indMin] = tmp;
        }
    }

}
