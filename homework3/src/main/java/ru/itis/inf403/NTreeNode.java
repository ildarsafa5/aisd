package ru.itis.inf403;

import java.util.ArrayList;

public class NTreeNode<T> {
    public T value;
    public ArrayList<NTreeNode<T>> descendants  = new ArrayList<>();

    public NTreeNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NTreeNode{" +
                "value=" + value + '}';
    }
}
