package lesson20240117;

public class FindMax {

    public static void main(String[] args) {

        int[] data = {1, 4, 0, 2, -1, 4};

        System.out.println(max(data));
        System.out.println(divideAndConquerMax(data, 0));
    }

    public static int max(int[] data) {  // O(n)
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) max = data[i];
        }
        return max;
    }

    public static int divideAndConquerMax(int[] data, int i) { // O(n)
        if (i == data.length - 1) return data[data.length - 1];
        return Math.max(data[i], divideAndConquerMax(data, i + 1));
    }


}
