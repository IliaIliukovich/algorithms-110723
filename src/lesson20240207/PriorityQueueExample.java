package lesson20240207;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add("C");
        queue.add("A");
        queue.add("B");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }


}
