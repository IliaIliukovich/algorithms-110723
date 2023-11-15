package lesson20231115;

public class SequenceTask {

    /*
    Решить задачу через рекурсию, и далее оптимизовать алгоритм одним из
    методов динамического программирования:

Вычислить n-й член последовательности, заданной формулами:
sequence(2n) = sequence(n) + sequence(n-1),
sequence(2n+1) = sequence(n) — sequence(n-1),
sequence(0) = sequence(1) = 1.

1 1 2 0 3 1 2 -2

n = 0  ---> 1 1 (base condition)
n = 1 sequence(2) = sequence(1) + sequence(0) = 1 + 1 = 2
	  sequence(3) = sequence(1) - sequence(0) = 1 - 1 = 0
n = 2 sequence(4) = sequence(2) + sequence(1) = 2 + 1 = 3
	  sequence(5) = sequence(2) - sequence(1) = 2 - 1 = 1
n = 3 sequence(6) = sequence(3) + sequence(2) = 0 + 2 = 2
      sequence(7) = sequence(3) - sequence(2) = 0 - 2 = -2
     */

    public static void main(String[] args) {
        System.out.println("Recursive: " + sequence(0) + ", memo: " + sequenceMemo(0) + ", tab: " + sequenceTab(0));
        System.out.println("Recursive: " + sequence(1) + ", memo: " + sequenceMemo(1) + ", tab: " + sequenceTab(1));
        System.out.println("Recursive: " + sequence(2) + ", memo: " + sequenceMemo(2) + ", tab: " + sequenceTab(2));
        System.out.println("Recursive: " + sequence(3) + ", memo: " + sequenceMemo(3) + ", tab: " + sequenceTab(3));
        System.out.println("Recursive: " + sequence(4) + ", memo: " + sequenceMemo(4) + ", tab: " + sequenceTab(4));
        System.out.println("Recursive: " + sequence(5) + ", memo: " + sequenceMemo(5) + ", tab: " + sequenceTab(5));
        System.out.println("Recursive: " + sequence(6) + ", memo: " + sequenceMemo(6) + ", tab: " + sequenceTab(6));
        System.out.println("Recursive: " + sequence(7) + ", memo: " + sequenceMemo(7) + ", tab: " + sequenceTab(7));
    }

    public static int sequence(int m) {
        if (m == 0 || m == 1) return 1;
        if (m % 2 == 0) return sequence(m/2) + sequence(m/2 - 1);
        else return sequence(m/2) - sequence(m/2 - 1);
    }

    public static int sequenceMemo(int m){
        if (m == 0 || m == 1) return 1;
        int[] cache = new int[m + 1];
        cache[0] = cache[1] = 1;
        return sequenceMemo(cache, m);
    }

    private static int sequenceMemo(int[] cache, int m) {
        if (m == 0 || m == 1) return 1;
        if (cache[m] != 0) return cache[m];
        if (m % 2 == 0) cache[m] = sequenceMemo(cache, m/2) + sequenceMemo(cache, m/2 - 1);
        else cache[m] = sequenceMemo(cache, m/2) - sequenceMemo(cache, m/2 - 1);
        return cache[m];
    }

    public static int sequenceTab(int m){
        if (m == 0 || m == 1) return 1;

        int[] sequence = new int[m + 1];
        sequence[0] = sequence[1] = 1;
        for (int i = 2; i <= m; i++) {
            if (i % 2 == 0) {
                sequence[i] = sequence[i / 2] + sequence[i / 2 - 1];
            } else {
                sequence[i] = sequence[i / 2] - sequence[i / 2 - 1];
            }
        }
        return sequence[m];
    }

}
