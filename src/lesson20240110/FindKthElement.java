package lesson20240110;

import java.util.HashMap;
import java.util.Map;

public class FindKthElement {

//      Task: Первый элемент, встречающийся k раз в массиве
//     Дан массив из n целых чисел. Задача состоит в том, чтобы найти первый элемент, который встречается k раз.
//     Если ни один элемент не встречается k раз, выведите -1.
//     Распределение целочисленных элементов может быть в любом диапазоне.
//
//     Ввод : {1, 7, 4, 3, 4, 8, 7}, k = 2
//     Вывод : 7
//     Объяснение: И 7, и 4 встречаются 2 раза. Но 7 — это первое число, которое встречается 2 раза.
    public static void main(String[] args) {
        int[] data = {1, 7, 4, 3, 4, 8, 7};
        System.out.println(findKth(data, 2));
    }

    public static int findKth(int[] data, int k) { // O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i])){   // O(1)
                map.put(data[i], map.get(data[i]) + 1); // O(1)
            } else {
                map.put(data[i], 1); // O(1)
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (map.get(data[i]) == k) return data[i];  // O(1)
        }
        return -1;
    }


}
