package ru.itis.inf403;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = ")()))";
        System.out.println(checkBrackets(s));
        System.out.println(mathOperation("3 2 - 3 +"));

        Integer[] a = {1,2,2,2,2};
        System.out.println(Arrays.toString(set(a)));
    }

    public static int checkBrackets(String str) {
        Stack<Character> stack = new Stack();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                if (str.charAt(i) == ')') {
                    cnt++;
                } else {
                    stack.push(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        cnt+=stack.size();
        return cnt;
    }

    public static int mathOperation(String str) {
        String[] array = str.split(" ");
        int value = 0;
        int cur =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("-")) {
                value = Integer.parseInt(array[cur]);
                for (int j = cur+1; j < i; j++) {
                    value = value - Integer.parseInt(array[j]);
                }
                cur = i+1;
            }
            if (array[i].equals("+")) {
                for (int j = cur; j < i; j++) {
                    value += Integer.parseInt(array[j]);
                }
                cur = i+1;
            }
            if (array[i].equals("*")) {
                value = Integer.parseInt(array[cur]);
                for (int j = cur+1; j < i; j++) {
                    value *= Integer.parseInt(array[j]);
                }
                cur = i+1;
            }
        }
        return value;
    }

    public static Integer[] set(Integer[] array) {
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i-1])) {
                list.add(array[i]);
            }
        }
        return list.toArray(new Integer[] {});
    }
}
