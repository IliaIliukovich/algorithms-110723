package lesson20240214;

public class FastAndSlowFrog {

    public static void main(String[] args) {
        Node node5 = new Node("E", null);
        Node node4 = new Node("D", node5);
        Node node3 = new Node("C", node4);
        Node node2 = new Node("B", node3);
        Node node1 = new Node("A", node2);

        Node first = node1;
        findLoop(first);

       node5 = new Node("E", null);
       node4 = new Node("D", node5);
       node3 = new Node("C", node4);
       node2 = new Node("B", node3);
       node1 = new Node("A", node2);
       node5.next = node2;

       first = node1;
       findLoop(first);
    }

    public static void findLoop(Node first) {
        Node slow = first;
        Node fast = first;
        if (fast == null) {
            System.out.println("No loop found");
            return;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop found. Stopped on: " + slow);
                return;
            }
        }
        System.out.println("No loop found");
    }


    static class Node {
        String data;

        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + "}";
        }
    }



}
