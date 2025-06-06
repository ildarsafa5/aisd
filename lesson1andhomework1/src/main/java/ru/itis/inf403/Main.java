package ru.itis.inf403;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {3,6,4,1,5};
        for (int i = 0; i < a.length; i++) {
            int minpos = i;
            for (int j = i; j < a.length; j++) {
                if (a[j]<a[minpos]) {
                    minpos = j;
                }
            }
            int temp = a[i];
            a[i] = a[minpos];
            a[minpos] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
