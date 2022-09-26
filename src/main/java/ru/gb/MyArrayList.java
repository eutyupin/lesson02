package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> {
    private T[] innerList;

    List<String> list = new ArrayList<>();
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity can not be <= 0");
        innerList = (T[]) new Object[capacity];
    }

    public MyArrayList() {
        innerList = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        innerList[size] = item;
        size++;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            sb.append(String.valueOf(innerList[i])).append(", ");
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }

    public void add(int index, T item) {
        if(!checkIndex(index)) throw new IllegalArgumentException("incorrect index");
        for (int i = size; i > index ; i--) {
            innerList[i] = innerList[i-1];
            innerList[index] = item;
            size++;
        }
    }

    private int index(T item) {
        for (int i = 0; i < size; i++) {
            if (innerList[i].equals(item) && innerList[i] != null) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(T item) {
        return index(item);
    }

    public void remove(int index) {
        if(!checkIndex(index)) throw new IllegalArgumentException("incorrect index");
        for (int i = 0; i < size; i++) {
            innerList[i] = innerList[i+1];
        }
        size--;
    }

    public void remove(T item) {
        int i = index(item);
        remove(i);
    }

    private boolean checkIndex(int index) {
        if(index < 0 || index > size) return false;
        else return true;
    }

    public int size() {
        return size;
    }
}
