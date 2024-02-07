package lesson20240207;

import java.util.Arrays;

public class MaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] queue;
    private int n;

    public MaxPriorityQueue(int capacity) {
        queue = (Key[]) new Comparable[capacity + 1];
    }

    public void insert(Key key) {
        queue[++n] = key;
        swim(n);
    }

    public Key delMax() {
        Key max = queue[1];
        swap(1, n--);
        sink(1);
        queue[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && queue[k/2].compareTo(queue[k]) < 0){
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && queue[j].compareTo(queue[j + 1]) < 0) j++;
            if (queue[k].compareTo(queue[j]) >= 0) break;
            swap(k ,j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        Key tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {
        MaxPriorityQueue<Integer> maxPriorityQueue = new MaxPriorityQueue<>(10);
        maxPriorityQueue.insert(1);
        maxPriorityQueue.insert(2);
        maxPriorityQueue.insert(3);
        maxPriorityQueue.insert(4);
        maxPriorityQueue.insert(5);
        maxPriorityQueue.insert(6);
        maxPriorityQueue.insert(7);
        maxPriorityQueue.insert(8);
        maxPriorityQueue.insert(9);
        maxPriorityQueue.insert(10);
        maxPriorityQueue.printInnerStructure();
        System.out.println("Max: " + maxPriorityQueue.delMax());
        System.out.println("Max: " + maxPriorityQueue.delMax());
        maxPriorityQueue.printInnerStructure();
    }

    private void printInnerStructure() {
        System.out.println(Arrays.toString(queue));
    }

}
