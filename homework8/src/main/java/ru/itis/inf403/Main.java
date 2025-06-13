package ru.itis.inf403;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //поиск подмножества из 3-х элементов
        System.out.println(Arrays.toString(first(new int[]{17,24,1,98,35,7,64,125}, 100)));
        //игра в палочки
        List<List<Integer>> m = new ArrayList<>();
        m.add(List.of());
        m.add(List.of(2));
        m.add(List.of(1));
        m.add(List.of(1,3));
        m.add(List.of(1,2));
        m.add(List.of(1,2));
        m.add(List.of(1,3));
        second(6, m);
    }

    public static int[] first(int[] array, int t) {
        Arrays.sort(array);
        int n = array.length;
        int s = array[0] + array[1] + array[2];
        int[] m = new int[3];
        m[0] = array[0];
        m[1] = array[1];
        m[2] = array[2];

        for (int i = 0; i < n - 2; ++i) {
            int l = i + 1;
            int h = n - 1;

            while (l < h) {
                int c = array[i] + array[l] + array[h];
                if (Math.abs(c - t) < Math.abs(s - t)) {
                    s = c;
                    m[0] = array[i];
                    m[1] = array[l];
                    m[2] = array[h];
                }
                if (c < t) {
                    l++;
                } else if (c > t) {
                    h--;
                } else {
                    return m;
                }
            }
        }
        return m;
    }

    public static void second(int n, List<List<Integer>> move) {
        boolean[] array = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            for (int t : move.get(i)) {
                if (i-t >= 0 && !array[i-t]) {
                    array[i] = true;
                    break;
                }
            }
        }
        if (array[n]) {
            System.out.println("Первый победил");
        } else {
            System.out.println("Второй победил");
        }
    }
}

