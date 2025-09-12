package HashMapsAndHashFunctions;

import java.util.*;

public class CustomHashMap<K, V> {

    private static final int SIZE = 16;

    private LinkedList<Node<K, V>>[] buckets;

    // Node class representing key-value pairs
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap() {
        buckets = new LinkedList[SIZE];
    }

    // Hash function to get index for a key
    private int getIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if key already exists; if yes, update value
        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If key doesn't exist, add new node
        buckets[index].add(new Node<>(key, value));
    }

    // Retrieve value for a key
    public V get(K key) {
        int index = getIndex(key);
        if (buckets[index] == null) return null;

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getIndex(key);
        if (buckets[index] == null) return;

        Iterator<Node<K, V>> it = buckets[index].iterator();
        while (it.hasNext()) {
            if (it.next().key.equals(key)) {
                it.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println("apple: " + map.get("apple"));   // 10
        System.out.println("banana: " + map.get("banana")); // 20

        map.put("apple", 100); // Update value
        System.out.println("apple (updated): " + map.get("apple")); // 100

        map.remove("banana");
        System.out.println("banana (after removal): " + map.get("banana")); // null
    }
}
