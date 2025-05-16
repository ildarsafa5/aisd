package ru.itis.inf403.linkedlist;

public class Main {
    public static void main(String[] args) {
        addTest();
    }

    public static void addTest() {
        LinkedListImpl<Integer> list = new LinkedListImpl<Integer>(10);
        list.add(15);
        list.add(10);
        list.add(4);
        list.add(1);
        list.reverse(1);
        System.out.println(list);
    }
}
