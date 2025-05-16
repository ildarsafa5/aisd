package ru.itis.inf403;

public class Node<T> {
    public T value;
    public Node left;
    public Node right;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
