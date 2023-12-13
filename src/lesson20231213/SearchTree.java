package lesson20231213;

import java.util.Arrays;
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

    public Integer get(String key) { // O(log n) if tree is balanced // O(n) if tree is not balanced
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

    private Node add(Node current, String key, Integer value) { // O(log n) if tree is balanced // O(n) if tree is not balanced
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

    public Iterable<String> getAllKeys(){ // O(n)
        Queue<String> queue = new LinkedList<>();
        inorder(queue, root);
        return queue;
    }

    private void inorder(Queue<String> queue, Node current) {
        if (current.left != null) inorder(queue, current.left);
        queue.add(current.key);
        if (current.right != null) inorder(queue, current.right);
    }

    // O(n log(n)) time complexity
    // O(n) space complexity
    public static String[] sortWithTree(String[] data) {
        SearchTree tree = new SearchTree(); // O(1)
        for (String s : data) { // O(n log(n))
            tree.add(s, 0); // O(log n)
        }
        Iterable<String> keys = tree.getAllKeys(); // O(n)
        String[] sortedData = new String[data.length];
        int i = 0;
        for (String s : keys) { // O(n)
            sortedData[i++] = s;
        }
        return sortedData;
    }

    public String getMaxKey(){
        return null;
    }


    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.add("C", 10);
        tree.add("A", 20);
        tree.add("B", 30);
        tree.add("D", 40);
        tree.add("G", 90);

        // A B C D E

        System.out.println(tree.get("A"));
        System.out.println(tree.get("B"));
        System.out.println(tree.get("C"));
        System.out.println(tree.get("D"));
        System.out.println(tree.get("G"));
        System.out.println(tree.get("X"));

        System.out.println(tree.getAllKeys());

        String[] sorted = sortWithTree(new String[]{"Hello", "World", "C", "D", "A"});
        System.out.println(Arrays.toString(sorted));
    }

}
