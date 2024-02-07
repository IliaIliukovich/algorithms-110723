package lesson20240131;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomGenerator {


    // Тask: Реализуйте метод rand7() на базе метода rand5().
    //Другими словами, имеется метод, генерирующий случайные числа в диапазоне от О до 4 (включительно).
    //Напишите метод, который использует его для генерирования случайного числа в диапазоне от О до 6 (включительно).
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 7_000_000; i++) {
            map.merge(random7notUniformly(),1, Integer::sum);
        }
        System.out.println(map);

        map = new HashMap<>();
        for (int i = 0; i < 7_000_000; i++) {
            map.merge(random7(),1, Integer::sum);
        }
        System.out.println(map);
    }

    public static int random5(){ // 0 1 2 3 4
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int random7notUniformly() { // 0 1 2 3 4 5 6
        int newRandom = random5() + random5();  // 0 -- 8
        // bad solution: numbers will not be uniformly distributed
        // 0 + 0 = 0 -----> 1/5 * 1/5 = 1/25
        // 0 + 1 = 1
        // 1 + 0 = 1 -----> 2/25

        newRandom = newRandom % 7;
        return newRandom;
    }

    public static int random7() {
        while (true) {
            int num = 5 * random5() + random5();
            if (num < 21) {
                return num % 7;
            }
        }
    }

}
