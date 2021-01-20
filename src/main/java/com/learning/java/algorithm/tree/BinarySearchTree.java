package com.learning.java.algorithm.tree;

/**
 * 二叉搜索/查找树
 * */
public class BinarySearchTree extends BinaryTree {

    /**
     * 如何判断是否是二叉搜索树？
     * */
    public static boolean isValidBinarySearchTree(Node root, Node lower, Node upper) {
        if (root == null) return true;
        if (lower != null && root.data <= lower.data) return false;
        if (upper != null && root.data >= upper.data) return false;
        return isValidBinarySearchTree(root.left, null, root) && isValidBinarySearchTree(root.right, root, null);
    }

    public static void main(String[] args) {
        Node root = createBinarySearchTree();
        System.out.println(isValidBinarySearchTree(root, null, null));
        System.out.println("Print a binary search tree in InOrder:");
        printInOrder(root);
    }

}
