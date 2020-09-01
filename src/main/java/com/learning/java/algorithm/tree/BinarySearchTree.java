package com.learning.java.algorithm.tree;

public class BinarySearchTree extends BinaryTree {

    public static boolean isValidBinarySearchTree(Node root, Node lower, Node upper) {
        if (root == null) return true;
        if (lower != null && root.data <= lower.data) return false;
        if (upper != null && root.data >= upper.data) return false;
        return isValidBinarySearchTree(root.left, null, root) && isValidBinarySearchTree(root.right, root, null);
    }

    public static void main(String[] args) {
        Node root = BinaryTree.createBinarySearchTree();
        System.out.println(isValidBinarySearchTree(root, null, null));
        BinaryTree.printInOrder(root);
    }

}
