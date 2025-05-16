package ru.itis.inf403;

public class Main {
    public static void main(String[] args) {
        Node<Integer> head = new Node(1);
        head.left = new Node<>(2);
        head.right = new Node<>(3);
        head.left.left = new Node<>(4);
        head.left.right = new Node<>(5);
        head.right.right = new Node<>(6);

        ComputeTreeHeight tree = new ComputeTreeHeight();
        System.out.println(tree.getAllNodeHeight(head));

        System.out.println(TreeSerialization.toSerialization(head));

        NTreeNode<Integer> node1 = new NTreeNode(1);
        node1.descendants.add(new NTreeNode<>(2));
        node1.descendants.add(new NTreeNode<>(3));
        node1.descendants.add(new NTreeNode<>(4));
        node1.descendants.get(0).descendants.add(new NTreeNode<>(5));
        node1.descendants.get(0).descendants.add(new NTreeNode<>(6));
        node1.descendants.get(1).descendants.add(new NTreeNode<>(7));
        node1.descendants.get(1).descendants.add(new NTreeNode<>(8));
        node1.descendants.get(1).descendants.add(new NTreeNode<>(9));
        node1.descendants.get(1).descendants.get(0).descendants.add(new NTreeNode<>(10));

        System.out.println(NTreeSerialization.toSerialization(node1));
    }
}
