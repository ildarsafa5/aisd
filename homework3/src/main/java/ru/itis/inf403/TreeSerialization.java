package ru.itis.inf403;

public class TreeSerialization {
    public static String toSerialization(Node node) {
        String seria;
        if (node == null) {
            return "()";
        }
        seria = "(" + node.value + "," + toSerialization(node.left) + "," + toSerialization(node.right) + ")";
        return seria;
    }
}