package com.learning.java.algorithm.tree;

public class BinarySearchTree extends BinaryTree {

    public static void main(String[] args) {
        Node root = BinaryTree.createBinarySearchTree();
        BinaryTree.printInOrder(root);
    }

}
