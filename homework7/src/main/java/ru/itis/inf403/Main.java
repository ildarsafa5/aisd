package ru.itis.inf403;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{4,5,1,1},{1,1,2,3},{1,2,1,3},{1,10,1,1}};
        System.out.println(MinTortoise(array));
    }

    public static int MinTortoise(int[][] array) {
        int stroki = array.length;
        int stolbci = array[0].length;
        int[][] current = new  int[stroki][stolbci];
        current[0][0] = array[0][0];
        for (int i = 1; i < stolbci; i++) {
            current[0][i] = current[0][i-1]+array[0][i];
        }
        for (int i = 1; i < stroki; i++) {
            current[i][0] = current[0][i-1] + array[i][0];
        }

        for (int i = 1; i < stroki; i++) {
            for (int j = 1; j < stolbci; j++) {
                current[i][j] = array[i][j] + min(current[i-1][j],current[i][j-1]);
            }
        }
        return current[stroki-1][stolbci-1];
    }

    public static int min(int first,int second) {
        return first>second?second:first;
    }
}
