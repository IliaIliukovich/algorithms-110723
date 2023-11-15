package lesson20231115;

public class FibonacciSequence {

    public static void main(String[] args) {

        // fibonacci sequence c = a + b  // f(n) = f(n - 1) + f(n - 2)
        // 0 1 1 2 3 5 8 13 21 ...
        // fibonacci(5) = 5
        // fibonacci(6) = 8


        System.out.println(fibonacciMemoization(30));
        System.out.println(fibonacciTabulation(30));
        System.out.println(fibonacciTabulationOptimized(30));
        System.out.println(fibonacci(30));
    }

    // time: O(n)
    // space: O(1)
    public static int fibonacciTabulationOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int cache1 = 0;
        int cache2 = 1;
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result = cache1 + cache2;
            cache1 = cache2;
            cache2 = result;
        }
        return result;
    }

    // time: O(n)
    // space: O(n)
    public static int fibonacciTabulation(int n) {
        if (n == 0) return 0;
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    // O(2^n)
    public static int fibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciMemoization(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;

        return fibonacciMemoization(cache, n);
    }

    // O(n)
    private static int fibonacciMemoization(int[] cache, int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache[n]  != 0) return cache[n];
        cache[n] = fibonacciMemoization(cache, n - 1) + fibonacciMemoization(cache, n - 2);
        return cache[n];
    }
}
