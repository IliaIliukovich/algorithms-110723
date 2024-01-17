package lesson20240117;

public class PowerFunction {


    // x^a
    public static void main(String[] args) {
        int x = 2;
        int a = 10;
        System.out.println(powerInLoop(x, a));
        System.out.println(powerDivideAndConquer(x, a));

    }

        // x * x * x * x * x * x * x * x   --- 7 operations
    public static int powerInLoop(int x, int a) { // O(a)
        int result = 1;
        for (int i = 0; i < a; i++) {
            result = x * result;
        }
        return result;
    }
        // x * x * x * x * x * x * x * x
        // (x * x * x * x) * (x * x * x * x) z * z
        // ((x * x) * (x * x)) * ((x * x) * (x * x))  z = y * y
        // y = x * x  -- 3 operations

    public static int powerDivideAndConquer(int x, int a) { // O(log n)
        if (a == 1) return x;
        if (a % 2 == 0) {
            int result = powerDivideAndConquer(x, a / 2);
            return result*result;
        } else {
            return x * powerDivideAndConquer(x, a - 1);
        }
    }

}
