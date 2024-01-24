package lesson20240124;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Tasks {

    // 1. Написать метод проверки isSorted(), является ли данный массив отсортированным.
    // 2. Написать метод случайного перемешивания данных в массиве.
    //Input:  1, 2, 2, 3, 4
    //Output: 2, 1, 2, 4, 3

    public static void main(String[] args) {
        int[] data = {1, 1, 5, 6};

        System.out.println(isSorted(data));

        shuffle(data);
//        Collections.shuffle();
        System.out.println(Arrays.toString(data));
        System.out.println(isSorted(data));
    }

    public static boolean isSorted(int[] data) {  // O(n)
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) return false;
        }
        return true;
    }

    public static void shuffle(int[] data) { // O(n log n)
        Data[] tmpData = new Data[data.length];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            tmpData[i] = new Data(data[i], random.nextInt());
        }
        Arrays.sort(tmpData, Comparator.comparingInt(d -> d.valueForSort ));
        for (int i = 0; i < data.length; i++) {
            data[i] = tmpData[i].value;
        }
    }

    static class Data {
        int value;
        int valueForSort;

        public Data(int value, int valueForSort) {
            this.value = value;
            this.valueForSort = valueForSort;
        }
    }

}
