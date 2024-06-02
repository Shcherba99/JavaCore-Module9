package com.goit.javacore.module8.pshcherba.collections;

import java.util.Objects;

public class MyArrayList<T> {
    private static final int START_CAPACITY = 10;
    private static final double CAPACITY_INCREASE_COEFFICIENT = 1.5;
    private int size = 0;
    private T[] array;

    public MyArrayList() {
        array = (T[]) new Object[START_CAPACITY];
    }


    public void add(T value) {
        if (size >= array.length) {
            T[] newArray = (T[]) new Object[(int) (array.length * CAPACITY_INCREASE_COEFFICIENT)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index,size);

        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }

        array[--size] = null;
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

    public T get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }
}
