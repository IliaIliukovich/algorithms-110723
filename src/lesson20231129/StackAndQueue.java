package lesson20231129;

import java.util.*;

public class StackAndQueue {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<String> queue = new ArrayDeque<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A"); // use as stack
        deque.addFirst("B");
        deque.addFirst("C");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());

        deque.addFirst("A"); // use as queue
        deque.addFirst("B");
        deque.addFirst("C");
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());

//        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(String::length));
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Hello World");
        priorityQueue.add("Three");
        priorityQueue.add("One");
        priorityQueue.add("Two");
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }


}
