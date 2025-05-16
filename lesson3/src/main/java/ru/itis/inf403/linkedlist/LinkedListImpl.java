package ru.itis.inf403.linkedlist;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size=0;

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<T> {
        private Node<T> current = first;
        private T main;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            main = current.value;
            current = current.next;
            return main;
        }
    }

    public class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public LinkedListImpl() {
    }

    public LinkedListImpl(T value) {
        first = new Node<T>(value);
        size=1;
        this.last = first;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node<T>(value);
            last = first;
        } else {
            Node<T> news = new Node<T>(value);
            last.next = news;
            news.prev = last;
            last = news;
        }
        size++;
    }

    public void add(int position, T value) throws IndexOutOfBoundsException{
        Node<T> current = first;
        if (position<1 || position>size+1) {
            throw new IndexOutOfBoundsException();
        } else if (position == 1) {
            Node<T> cur = new Node<T>(value);
            cur.next = first;
            first.prev = cur;
            first = cur;

        }else if (position <= size){
            Node<T> news = new Node<T>(value);
            current = first;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            Node<T> prevPositionNode = current;
            current.prev.next = news;
            news.prev = current.prev;
            news.next = prevPositionNode;
            prevPositionNode.prev = news;
        } else{
            add(value);
        }
        size++;
    }

    public T pop() {
        Node<T> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        last = current.prev.next;
        size--;
        return current.value;

    }

    public T remove(int position) {
        if (position > size || position < 1) {
            throw new IndexOutOfBoundsException();
        } else if (position==1) {
            Node<T> current1 = first;
            first = first.next;
            first.next.prev = null;
            size--;
            return current1.value;
        } else if (position == size) {
            pop();
            return last.value;
        }
        Node<T> current = first;
        for (int i = 1; i < position-1; i++) {
            current = current.next;
        }
        Node<T> current1 = current.next;
        current.next = current.next.next;
        current.next.next.prev = current;
        size--;
        return current1.value;
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

    public T indexOf(int position) {
        if (position > size || position<1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> current = first;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    public void swap(int pos1, int pos2) {
        Node<T> current = first;
        int cnt = 1;
        while(cnt!=pos1) {
            current = current.next;
            cnt++;
        }
        T val1 = current.value;
        cnt=1;
        Node<T> current1 = first;
        while(cnt!= pos2) {
            current1 = current1.next;
            cnt++;
        }
        T val2 = current1.value;
        current.value = val2;
        current1.value = val1;
    }

    public int size() {
        return size;
    }

    public void reverse(int cur) {
        if (cur == size+1-cur) {
            return;
        }
        swap(cur,(size+1)-cur);
        reverse(cur+1);
    }

}
