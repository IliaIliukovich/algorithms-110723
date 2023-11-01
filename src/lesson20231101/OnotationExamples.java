package lesson20231101;

public class OnotationExamples {

    public static void main(String[] args) {

        // O(x^2 + x) = O(x^2)

        int[] data = new int[] {1, 3, 5, 12};

        processData(data);

        System.out.println(sum(5, 6));
        System.out.println(sumArray(new int[] {1, 4, 5}));
    }

    // Time complexity: O(3) = O(1)
    // Space complexity: O(1)
    public static int sum(int a, int b){
        int result = a + b; // 2
        return result; // 1
    }

    // Time complexity: 1 + 3*(n+1) + 2n + 1 = 5n + 5
    // O(5n + 5) = O(5n) = O(n)
    // Space complexity: O(2) = O(1)
    public static int sumArray(int[] ints) {
        int sum = 0; // 1
        for (int i = 0; i < ints.length; i++) { // 3 * (n + 1)
            sum = sum + ints[i]; // n * 2
        }
        return sum; // 1
    }

    //Time complexity:
    // n * n = n^2
    // best case = worst case O(n^2)
    public static void processData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Processing data " + data[i]);
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count = count + data[i] + data[j];
            }
            System.out.println("Count = " + count);
        }
    }


}
