package lesson20231108;

public class Tasks {

    public static void main(String[] args) {

    // task 1: n! = 1 * 2 * 3 * ... * n
        System.out.println(factorial(5));
    }

    // O(n)
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1; // base condition
        return n * factorial(n - 1);
    }



}
