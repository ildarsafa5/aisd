package ru.itis.inf403.linkedlist;

import java.util.Iterator;

public interface LinkedList<T> extends Iterable<T> {
    public void add(T element);
    public void add(int position, T value);
    public T pop();
    public T remove(int position);
    public T indexOf(int position);

}
