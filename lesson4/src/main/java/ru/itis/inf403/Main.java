package ru.itis.inf403;

public class Main {
    public static void main(String[] args) {
        first(new int[] {1,4,4,4,7},4);
//        str("aabaa","aaaab");
    }

    public static void first(int[] array, int a) {
        int left = 0;
        int right = array.length-1;
        int mid;
        while(left<=right) {
            mid = (left+right)/2;
            if (array[mid]>=a) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        System.out.println(left);
        left = 0;
        right = array.length -1;
        while(left<=right) {
            mid = (left+right)/2;
            if (array[mid]<=a) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(left-1);
    }

    public static void str(String s, String t) {
        String s1 = s + s;
        System.out.println(s1.indexOf(t)-1);
    }


}
