package lesson20240214;

public class SlidingWindow {

    public static void main(String[] args) {

        // Task: создать алгоритм нахождения подпоследовательности
        // с наибольшей суммой из всех возможных подпоследовательностей.
        int[] data = {2, 5, -8, 3, 9, -2, -4, 0, 2, 6, -3, -5, 0, -4, 2, 3, 1};
        findMaxSum(data);

        // Task: Дан массив целых чисел размера «n»,
        // требуется вычислить максимальную сумму «k» последовательных элементов в массиве.
        data = new int[]{9, 4, 5, 1, 7, 3, 10};
        int k = 3;
        System.out.println(findMaxKelementSum(data, k));
    }

    public static void findMaxSum(int[] data) {
        int maxSum = data[0];
        int maxStartIndex = 0;
        int maxWindowLength = 1;

        int currentSum = data[0];
        int currentStartIndex = 0;
        int currentWindowLength = 1;

        for (int i = 1; i < data.length; i++) {
            if (currentSum < 0) {
                currentSum = data[i];
                currentStartIndex = i;
                currentWindowLength = 1;
            } else {
                currentSum = currentSum + data[i];
                currentWindowLength++;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStartIndex = currentStartIndex;
                maxWindowLength = currentWindowLength;
            }
        }
        System.out.println("Max sum: " + maxSum);
        System.out.println("Max start index: " + maxStartIndex);
        System.out.println("Max window length: " + maxWindowLength);
    }

    public static int findMaxKelementSum(int[] data, int k) { // O(n)
        int sumMax = 0;
        for (int i = 0; i < k; i++) {
            sumMax += data[i];
        }

        int currentWindow = sumMax;
        for (int i = k; i < data.length; i++) {
            currentWindow = currentWindow - data[i - k] + data[i];
            sumMax = Math.max(sumMax, currentWindow);
        }
        return sumMax;
    }


}
