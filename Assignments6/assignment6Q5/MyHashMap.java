package assignment6Q5;

public class MyHashMap {
    final Node[] nodes = new Node[10000];

    public void put(int key, int value) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = getPrev(nodes[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            return -1;
        }
        Node prev = getPrev(nodes[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            return;
        }
        Node prev = getPrev(nodes[index], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private Node getPrev(Node bucket, int key) {
        Node node = bucket;
        Node prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
