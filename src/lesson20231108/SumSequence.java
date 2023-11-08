package lesson20231108;

public class SumSequence {

    public static void main(String[] args) {
        // n ---> 1 + 2 + 3 + 4 + ... + n

        System.out.println(sumInLoop(5));
        System.out.println(sumRecursive(5));
    }

    // time: O(n)
    // space: O(n)
    public static int sumRecursive(int n) {
        if (n == 1) return 1; // base condition
        int result = n + sumRecursive(n - 1);
        return result;
    }

    // time: O(n)
    // space: O(1)
    public static int sumInLoop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }


}
