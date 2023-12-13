package lesson20231213;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {

    private Node root;

    static private class Node {
        String key;
        Integer value;

//        List<Node> children;
        Node left;
        Node right;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Integer get(String key) {
        Node current = root;

        while (current != null) {
            int result = key.compareTo(current.key);
            if (result == 0) return  current.value;
            else if (result < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public void add(String key, Integer value) {
            root = add(root, key, value);
    }

    private Node add(Node current, String key, Integer value) {
        if (current == null) {
            current = new Node(key, value);
        } else {
            int result = key.compareTo(current.key);
            if (result == 0) current.value = value;
            else if (result < 0) current.left = add(current.left, key, value);
            else current.right = add(current.right, key, value);
        }
        return current;
    }

    public Iterable<String> getAllKeys(){
        Queue<String> queue = new LinkedList<>();
        inorder(queue, root);
        return queue;
    }

    private void inorder(Queue<String> queue, Node current) {
        if (current.left != null) inorder(queue, current.left);
        queue.add(current.key);
        if (current.right != null) inorder(queue, current.right);
    }


    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.add("C", 10);
        tree.add("A", 20);
        tree.add("B", 30);
        tree.add("D", 40);
        tree.add("G", 90);

        System.out.println(tree.get("A"));
        System.out.println(tree.get("B"));
        System.out.println(tree.get("C"));
        System.out.println(tree.get("D"));
        System.out.println(tree.get("X"));

        System.out.println(tree.getAllKeys());
    }

}
