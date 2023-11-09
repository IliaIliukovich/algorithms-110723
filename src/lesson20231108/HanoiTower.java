package lesson20231108;

public class HanoiTower {

    public static void main(String[] args) {

        hanoiRecursive(5, 'a', 'b', 'c');

    }

    // time O(2^n)
    public static void hanoiRecursive(int n, char start, char middle, char end) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + start + " to " + end); // base condition
            return;
        }
        hanoiRecursive(n - 1, start, end, middle);
        System.out.println("Move disk " + n + " from " + start + " to " + end);
        hanoiRecursive(n - 1, middle, start, end);
    }

}
