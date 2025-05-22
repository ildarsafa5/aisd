package ru.itis.inf403;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
         int[] array = new int[] {9,8,6,8,9};
        System.out.println(modifiedBinarySearch(array));
        Integer[] array1 = new Integer[] {3,30,34,5,9};
        sliyanie(array1);
        System.out.println(maxSum(array,21));
        string("ildar lubit mamu");
    }

    public static int modifiedBinarySearch(int[] array) {
        int left = 0;
        int right = array.length-1;
        int mid;
        while(left<right) {
            mid = (left+right)/2;
            if (array[mid]>array[mid+1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void sliyanie(Integer[] array) {
        //TimSort сложность O(nlogn)
        Arrays.stream(array).sorted((o1,o2) -> (o2.toString()+o1.toString()).compareTo((o1.toString()+o2.toString()))).forEach(o -> System.out.print(o));
        System.out.println();
    }

    public static int maxSum(int[] array,int s) {
        //TimSort сложность O(nlogn)
        array = Arrays.stream(array).sorted().toArray();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result+=array[i];
            if (result>s) {
                return i;
            }
        }
        return 0;
    }

    public static void string(String s) {
        int cur = s.length();
        // суммарно сложность O(2n) = O(n), так как во внешнем цикле бежим по n символам
        // а во внутреннем суммарно по всем словам -> по n символам, то есть бежим по каждому слову 2 раза
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) == ' ') {
                for (int j = i+1; j < cur; j++) {
                    System.out.print(s.charAt(j));
                }
                System.out.print(" ");
                cur = i;
            }
        }
        for (int i = 0; i < cur; i++) {
            System.out.print(s.charAt(i));
        }
    }
}
