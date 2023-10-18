package lesson20231018;

public class GcdAlgorithm {

    public static void main(String[] args) {

        long start = System.nanoTime();
        int result = gcbEuclidean(24000, 36000);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("Time elapsed, Eucledean alg: " + (end - start));

        start = System.nanoTime();
        result = gcbBruteForce(24000, 36000);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("Time elapsed, bruteforce alg: " + (end - start));
    }

    public static int gcbBruteForce(int a, int b) {
        int x = Math.min(a, b);
        int y = Math.max(a, b);

        for (int i = x; i > 1; i--) {
            if (x % i == 0 && y % i == 0) return i;
        }
        return 1;
    }

    // Алгоритм Евклида
    //
    //Формула НОД: НОД (a, b) = НОД (b, с), где с — остаток от деления a на b.
    //
    //1 Большее число поделить на меньшее.
    //2 Меньшее число поделить на остаток, который получается после деления.
    //3 Первый остаток поделить на второй остаток.
    //4 Второй остаток поделить на третий и т. д.
    //5 Деление продолжается до тех пор, пока в остатке не получится нуль.
    // Последний делитель и есть наибольший общий делитель.
    public static int gcbEuclidean(int a, int b) {
        int x = Math.min(a, b);
        int y = Math.max(a, b);

        int result = x;

        while (y % x != 0){
            result = y % x;
            y = x;
            x = result;
        }
        return result;
    }


}
