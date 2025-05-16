package ru.itis.inf403;

import java.util.HashMap;

public class ComputeTreeHeight {
    private HashMap<Node, Integer> heights = new HashMap<>();

    public HashMap<Node, Integer> getAllNodeHeight(Node node) {
        getNodeHeight(node);
        return heights;
    }

    public int getNodeHeight(Node node) {
        if (node == null) {
            return -1;
        }
        if (heights.containsKey(node)) {
            return heights.get(node);
        }
        int height = 1 + Math.max(getNodeHeight(node.left), getNodeHeight(node.right));
        heights.put(node, height);
        return height;
    }
}
