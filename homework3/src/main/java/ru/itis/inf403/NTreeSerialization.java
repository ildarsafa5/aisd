package ru.itis.inf403;

public class NTreeSerialization {
    public static String toSerialization(NTreeNode node) {
        String seria;
        if (node == null) {
            return "()";
        }
        seria = "(" + node.value;
        if (!node.descendants.isEmpty()) {
            seria += ",";
            for (int i = 0; i < node.descendants.size(); i++) {
                seria += toSerialization((NTreeNode) node.descendants.get(i));
            }
        }
        seria = seria + ")";
        return seria;
    }
}
