package lesson20231206;

public class CustomLinkedList {

    private Node first;
//    private Node last;
//    private int size;

    private static class Node {
        String data;
        Node next;
//        Node prev;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void pushToHead(String element){ // O(1)
        Node node = new Node(element, first);
        first = node;
    }

    public void pushToTail(String element) { // O(n), can be improved to O(1)
        if (first == null) {
            first = new Node(element, null);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element, null);
        }
    }

    public void pushToIndex(String element, int index) { // O(n), can be improved to O(n/2)
        if (index == 0) {
            pushToHead(element);
            return;
        }
        Node previous = first;
        for (int i = 1; i <= index - 1; i++) {
            if (previous == null) throw new RuntimeException("Index is out of bounds");
            previous = previous.next;
        }
        if (previous == null) throw new RuntimeException("Index is out of bounds");
        Node newNode = new Node(element, previous.next);
        previous.next = newNode;
    }

    public String get(int index){ // O(n), can be improved to O(n/2)
        Node current = first;
        for (int i = 1; i <= index; i++) {
            if (current == null) throw new RuntimeException("Index is out of bounds");
            current = current.next;
        }
        if (current == null) throw new RuntimeException("Index is out of bounds");
        return current.data;
    }

    public void removeFirst() { // O(1)
        if (first == null) throw new RuntimeException("No elements in list");
        first = first.next;
    }

    public void removeLast() { // TODO, O(n), can be improved to O(1)

    }

    public void remove(int index) { // TODO, O(n), can be improved to O(n/2)

    }

    public int size() { // O(n), can be improved to O(1)
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void print() { // O(n)
        Node current = first;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        System.out.println("Test 1");
        linkedList.pushToHead("A");
        linkedList.pushToHead("B");
        linkedList.pushToHead("C");
        linkedList.pushToHead("D");
        linkedList.print();
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();

        System.out.println("Test 2");
        linkedList.pushToTail("A");
        linkedList.pushToTail("B");
        linkedList.pushToTail("C");
        linkedList.pushToTail("D");
        linkedList.print();

        System.out.println("Test 3");
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));

        System.out.println("Test 4");
        linkedList.pushToIndex("E", 2);
        linkedList.print();
        System.out.println("Size = " + linkedList.size());
    }

}
