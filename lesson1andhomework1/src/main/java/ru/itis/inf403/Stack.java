package ru.itis.inf403;



public class Stack<T> {
    private Node<T> first;
    private Node<T> last;


    class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public void push(T value) {
        if (first == null) {
            first = new Node<T>(value);
            last = first;
        } else {
            Node<T> news = new Node<T>(value);
            last.next = news;
            news.prev = last;
            last = news;
        }
    }
    public boolean isEmpty() {
        return first==null;
    }


    public T pop() {
        if (first == null) {
            return null;
        }
        T cur = last.value;
        last.prev.next = null;
        last = last.prev;
        return cur;
    }

    public T peek() {
        return last.value;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<T> current = first;
        s.append(first.value).append(" ");
        while (current.next != null) {
            s.append(" | ").append(current.next.value);
            current = current.next;
        }
        return s.toString();
    }
}
