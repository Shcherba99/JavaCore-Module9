package com.goit.javacore.module8.pshcherba.collections;

public class MyQueue<T> {
    private Node first;
    private Node last;
    private int size = 0;


    public void add(T value) {
        Node node = new Node();
        node.value = value;

        if (last != null) {
            last.next = node;
        }

        last = node;

        if (first == null) {
            first = node;
        }

        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (first == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return first.value;
    }

    public T pool() {
        if (first == null) {
            throw new IllegalStateException("Queue is empty");
        }

        T value = first.value;
        first = first.next;
        size--;

        if (first == null) {
            last = null;
        }

        return value;
    }

    private class Node {
        Node next;
        T value;
    }
}
