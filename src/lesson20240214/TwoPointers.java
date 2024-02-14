package lesson20240214;

public class TwoPointers {

    // Найти два элемента из упорядоченного массива, сумма которых равна заданному числу givenSum

    public static void main(String[] args) {
        int[] sortedData = {1, 2, 2, 4, 5, 6, 8, 8, 11, 12};
        int givenSum = 13;
        bruteForceAlg(sortedData, givenSum);
        twoPointersAlg(sortedData, givenSum);
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


}
