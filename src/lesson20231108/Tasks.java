package lesson20231108;

public class Tasks {

    public static void main(String[] args) {

    // task 1: n! = 1 * 2 * 3 * ... * n
        System.out.println(factorial(5));



    // task 2: fibonacci sequence c = a + b  // f(n) = f(n - 1) + f(n - 2)
    // 0 1 1 2 3 5 8 13 21 ...
    // fibonacci(5) = 5
    // fibonacci(6) = 8
        System.out.println(fibonacciMemoization(45));
        System.out.println(fibonacci(45));
    }

    // O(n)
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1; // base condition
        return n * factorial(n - 1);
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
