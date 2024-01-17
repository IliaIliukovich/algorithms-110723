package lesson20240117;

public class SumElements {

    public static void main(String[] args) {
        int[] data = {1, 3, 10, 4, 5, 2, 10, 11};
        System.out.println(sumInLoop(data));
        System.out.println(sumDivideAndConquer(data));
    }

    // 1 + 3 + 10 + 4 + 5 + 2 + 10 + 11   7 operations O(n)
    public static int sumInLoop(int[] data) {
        int sum = 0;
        for (int d : data) {
            sum += d;
        }
        return sum;
    }

    // ((1 + 3) + (10 + 4)) + ((5 + 2) + (10 + 11))
    // 7 operations in 1 thread --- O(n) -----> 3 operations in parallel --- O(log n)
    // (1 + 3), (10 + 4), (5 + 2), (10 + 11) --- 1 operation in time -- 4 threads
    // (4 + 14), (7 + 21)  --- 2 operation in time --- 2 threads
    // (28 + 28)  --- 3 operation in time --- 1 thread
    public static int sumDivideAndConquer(int[] data) {
        return 0;
    }






}
