package com.goit.javacore.module8.pshcherba.collections;

import java.util.Objects;

public class MyLinkedList<T> {
    private final Node first;
    private final Node last;

    private int size;

    public MyLinkedList() {
        first = new Node();
        last = new Node();
        first.next = last;
        last.previous = first;
        size = 0;
    }

    public void add(T value) {
        Node node = new Node();
        node.value = value;
        Node lastNode = last.previous;

        lastNode.next = node;
        node.previous = lastNode;
        node.next = last;
        last.previous = node;
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);

        int currentIndex = 0;
        Node currentElement = first.next;
        while (currentElement != last) {
            if (currentIndex == index) {
                currentElement.previous.next = currentElement.next;
                currentElement.next.previous = currentElement.previous;
                size--;
                return;
            }
            currentElement = currentElement.next;
            currentIndex++;
        }
    }

    public void clear() {
        first.next = last;
        last.previous = first;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);

        int currentIndex = 0;
        Node currentElement = first.next;
        while (currentElement != last) {
            if (currentIndex == index) {
                return currentElement.value;
            }
            currentElement = currentElement.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Incorrect index");
    }

    private class Node {
        Node previous;
        Node next;
        T value;
    }
}
