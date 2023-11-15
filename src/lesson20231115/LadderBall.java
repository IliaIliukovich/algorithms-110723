package lesson20231115;

public class LadderBall {

    public static void main(String[] args) {
        System.out.println(pathTabulation(40));
        System.out.println(path(40));
    }

    public static long path(long n) {  // O(3^n) = O(2^n)
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        return path(n - 1) + path(n - 2) + path(n - 3);
    }

    public static long pathTabulation(long n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        long cache1 = 1;
        long cache2 = 2;
        long cache3 = 4;
        long result = 4;
        for (int i = 4; i <= n; i++) {
            result = cache1 + cache2 + cache3;
            cache1 = cache2;
            cache2 = cache3;
            cache3 = result;
        }
        return result;
    }


}
