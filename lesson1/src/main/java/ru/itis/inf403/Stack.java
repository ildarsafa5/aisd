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


    public T pop() {
        Node<T> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        last = current.prev.next;
        return current.value;
    }

    public T peek() {
        Node<T> current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
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
