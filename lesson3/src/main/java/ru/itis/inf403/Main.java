package ru.itis.inf403;


import ru.itis.inf403.linkedlist.LinkedListImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println(first(2));
    }

    public static double first(int n) {
        if (n==1) {
            return 0;
        }
        return first(n-1)+Math.log(n);
    }

    public static boolean da(int[] array, int s, int index) {
        if (s==0) {
            return true;
        }
        if (index>array.length || s<0) {
            return false;
        }
        return (da(array,s-array[index],index++) || da(array,s,index++));

    }

    public static int nod(int a, int b) {
        if (b== 0) {
            return a;
        }
        return nod(b,b&a);
    }


    public static int cnt(int cnt, Node current) {
        if (current == null) {
            return 0;
        }
        System.out.println(cnt(cnt++,current.left)+cnt(cnt++,current.right));
    }




}
