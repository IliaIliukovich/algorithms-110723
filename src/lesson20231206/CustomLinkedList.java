package lesson20231206;

public class CustomLinkedList {

    private Node first;

    private class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void pushToHead(String element){
        Node node = new Node(element, first);
        first = node;
    }

    public void pushToTail(String element) {
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

    public void pushToIndex(String element, int index) {

    }

    public String get(int index){
        Node current = first;
        for (int i = 1; i <= index; i++) {
            if (current == null) throw new RuntimeException("Index is out of bounds");
            current = current.next;
        }
        if (current == null) throw new RuntimeException("Index is out of bounds");
        return current.data;
    }

    public void print() {
        Node current = first;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
//        linkedList.pushToHead("A");
//        linkedList.pushToHead("B");
//        linkedList.pushToHead("C");
//        linkedList.pushToHead("D");
//        linkedList.print();
        linkedList.pushToTail("A");
        linkedList.pushToTail("B");
        linkedList.pushToTail("C");
        linkedList.pushToTail("D");
        linkedList.print();

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
    }



}
