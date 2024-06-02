package com.goit.javacore.module8.pshcherba.collections;

import java.util.Objects;

public class MyMap<K, V> {
    private Node head;
    private int size = 0;


    public void put(K key, V value) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(key, current.key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void remove(K key) {
        if (head == null) {
            throw new IllegalStateException("Key not found");
        }


        if (Objects.equals(key, head.key)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !Objects.equals(key, current.key)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            throw new IllegalStateException("Key not found");
        }

        previous.next = current.next;
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }


    public V get(K key) {
        Node current = head;

        while (current != null) {
            if (Objects.equals(key, current.key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }


    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
