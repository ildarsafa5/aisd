package ru.itis.inf403;

import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {
        String s1 = "({[}])";
        String s2 = "((((())";
        String s3 = "(()[{}])";
        String s4 = "(())";
        System.out.println(check(s1));
        System.out.println(check(s2));
        System.out.println(check(s3));
        System.out.println(check(s4));
    }

    public static boolean check(String str) {
        Stack<Character> a = new Stack();
        if (str.charAt(0) == '}' || str.charAt(0) == ')' || str.charAt(0) == ']') {
            return false;
        }
        a.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (a.isEmpty()) {
                if (str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']') {
                    return false;
                }
                a.push(str.charAt(i));
            } else {
                if (a.peek() == '{' && str.charAt(i)!='}') {
                    if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                        a.push(str.charAt(i));
                    } else {
                        return false;
                    }
                } else if (a.peek() == '(' && str.charAt(i)!=')') {
                        if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
                            a.push(str.charAt(i));
                        } else {
                            return false;
                        }
                } else if (a.peek() == '[' && str.charAt(i)!=']') {
                        if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                            a.push(str.charAt(i));
                        } else {
                            return false;
                        }
                } else {
                    a.pop();
                }
            }
        }
        if (a.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
