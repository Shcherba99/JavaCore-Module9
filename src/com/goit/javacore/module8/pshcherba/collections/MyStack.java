package com.goit.javacore.module8.pshcherba.collections;

import java.util.Objects;

public class MyStack<T> {
    private static final int START_CAPACITY = 10;
    private static final double CAPACITY_INCREASE_COEFFICIENT = 1.5;
    private int size = 0;
    private T[] array;

    public MyStack() {
        array = (T[]) new Object[START_CAPACITY];
    }

    public void push(T value) {
        if (size >= array.length) {
            T[] newArray = (T[]) new Object[(int) (array.length * CAPACITY_INCREASE_COEFFICIENT)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(0, index);

        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }

        array[size - 1] = null;
        size--;
    }

    public T get(int index) {
        Objects.checkIndex(0, index);
        return array[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T popElement = array[size - 1];
        array[--size] = null;
        return popElement;
    }
}
