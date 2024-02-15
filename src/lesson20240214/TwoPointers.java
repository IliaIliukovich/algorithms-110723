package lesson20240214;

import java.util.Arrays;

public class TwoPointers {


    public static void main(String[] args) {
        // Task: Найти два элемента из упорядоченного массива, сумма которых равна заданному числу givenSum
        int[] sortedData = {1, 2, 2, 4, 5, 6, 8, 8, 11, 12};
        int givenSum = 13;
        bruteForceAlg(sortedData, givenSum);
        twoPointersAlg(sortedData, givenSum);

        // Task: Возвести в квадрат отсортированный массив.
        // Результирующий массив тоже должен быть отсортирован
        int[] input = new int[] {-5, -1, 0, 1, 3, 6, 8};
        generateOrderedSquareSequence(input);
    }

    public static void bruteForceAlg(int[] sortedData, int givenSum) {
        for (int i = 0; i < sortedData.length; i++) {
            int current = sortedData[i];
            for (int j = i + 1; j < sortedData.length; j++) {
                int sum = current + sortedData[j];
                if (sum == givenSum) {
                    System.out.println("Found solution: " + current + " + " + sortedData[j] + " = " + sum);
                    return;
                }
            }
        }
        System.out.println("Solution not found");
    }

    public static void twoPointersAlg(int[] sortedData, int givenSum) {
        int pointerA = 0;
        int pointerB = sortedData.length - 1;

        while (pointerA != pointerB) {
            int sum = sortedData[pointerA] + sortedData[pointerB];
            if (sum < givenSum) pointerA++;
            else if (sum > givenSum) pointerB--;
            else {
                System.out.println("Found solution: " + sortedData[pointerA] + " + " + sortedData[pointerB] + " = " + sum);
                return;
            }
        }
        System.out.println("Solution not found");
    }

    public static void generateOrderedSquareSequence(int[] input) {
        int[] output = new int[input.length];
        int left = 0;
        int right = input.length - 1;
        int k = input.length - 1;

        while (left <= right){
            if (input[left] * input[left] >= input[right] * input[right]){
                output[k] = input[left] * input[left];
                left++;
            } else {
                output[k] = input[right] * input[right];
                right--;
            }
            k--;
        }

        System.out.println(Arrays.toString(output));
    }


}
